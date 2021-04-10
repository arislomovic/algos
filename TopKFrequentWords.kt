import java.util.*

object TopKFrequentWords : Problem.Medium(692) {

    private fun topKFrequent(words: Array<String>, k: Int) = words
        .countOccurrences()
        .run { keys.sortedWith(comparator) }
        .take(k)

    private fun topKFrequentQueue(words: Array<String>, k: Int) = words
        .countOccurrences()
        .run {
            val deque = PriorityQueue(k, comparator)
            for (i in this) {
                deque.add(i.key)
                if (deque.size > k) deque.poll()
            }
            deque.toList()
        }

    override fun runProblem() = topKFrequentQueue(testCases[0].first, testCases[0].second)
    override val testCases =
        arrayOf(
            arrayOf("i", "love", "leetcode", "i", "love", "coding") to 2,
            arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is") to 4,
        )
}