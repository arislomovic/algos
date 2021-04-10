object MostVisitedPattern : Problem.Medium(1152) {
    private fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
        val count = hashMapOf<List<String>, Int>()
        val users = hashMapOf<String, ArrayList<String>>()
        var index = 0
        while (index < username.size) {
            if (users[username[index]] == null) users[username[index]] = arrayListOf()
            val list = users[username[index]]!!
            if (list.size == 3) list.removeFirst()
            list.add(website[index])
            if (list.size == 3) {
                ArrayList(list).run { count[this] = count.getOrDefault(this, 0) + 1 }
            }
            index++
        }
        return count.entries.minByOrNull { it.value }?.key.orEmpty()
    }

    override fun runProblem() = testCases[0].run { mostVisitedPattern(first, second, third) }

    override val testCases = arrayOf(
        Triple(
            arrayOf("joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"),
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            arrayOf("home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career")
        )
    )
}