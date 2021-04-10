import java.util.*
import kotlin.collections.ArrayDeque


object AccountsMerge : Problem.Hard(721) {
    private fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        //GRAPH KEEPS EMAILS AND ATTACHES THE OWNING NAME TO IT
        val emailToName: HashMap<String, String> = HashMap<String, String>()
        //GRAPH STORES FIRST EMAIL IN LIST INTO LISTS OF ALL OTHER EMAILS AND STORES OTHER ELEMENTS INTO ITS OWN
        //IT ALSO DOES THE SAME THING FOR ALL OTHER EMAILS. SO THAT YOU  CAN LOOK UP THE LIST BY EMAIL IN O(1)
        val emailGraph: HashMap<String, ArrayList<String>> = HashMap()
        for (account in accounts) {
            val firstEmail = account[1]
            for (i in 1 until account.size) {
                val email = account[i]
                emailGraph.computeIfAbsent(email) { ArrayList() }.add(firstEmail)
                emailGraph.computeIfAbsent(firstEmail) { ArrayList() }.add(email)
                emailToName[email] = account[0]
            }
        }
        //STORES SEEN ELEMENTS
        val seen: HashSet<String> = HashSet<String>()
        val all: ArrayList<List<String>> = ArrayList()
        for (email in emailGraph.keys) {

            if (!seen.add(email)) continue

            //INITIALIZES SORTED QUEUE
            val currentList: PriorityQueue<String> = PriorityQueue() { o1, o2 -> o1.compareTo(o2) }
            currentList.add(emailToName[email]!!)

            val stack: ArrayDeque<String> = arrayDequeOf(email)

            while (stack.isNotEmpty()) {
                val currentEmail = stack.removeFirst()
                currentList.add(currentEmail)
                //GETS LIST ATTACHED TO EMAILS AND ADDS THEM TO STACK AS WELL, ETC
                for (neighbor in emailGraph[currentEmail]!!) {
                    if (seen.add(neighbor)) stack.addLast(neighbor)
                }
            }

            all.add(currentList.toList())
        }
        return all
    }


    override fun runProblem() = accountsMerge(testCases[2])
    override val testCases = arrayOf(
        listOf(
            listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            listOf("John", "johnsmith@mail.com", "john00@mail.com"),
            listOf("Mary", "mary@mail.com"),
            listOf("John", "johnnybravo@mail.com")
        ),
        listOf(
            listOf("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"),
            listOf("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"),
            listOf("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"),
            listOf("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"),
            listOf("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co")
        ),
        listOf(
            listOf("David", "David0@m.co", "David1@m.co"),
            listOf("David", "David3@m.co", "David4@m.co"),
            listOf("David", "David4@m.co", "David5@m.co"),
            listOf("David", "David2@m.co", "David3@m.co"),
            listOf("David", "David1@m.co", "David2@m.co")
        )
    )
}