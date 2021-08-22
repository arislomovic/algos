import java.util.*

object TopKFrequent : Problem.Medium(347) {

    private fun topKFrequent(nums: IntArray, k: Int) = nums
        .countOccurrences(HashMap())
        .entries
        .sortedWith { o1, o2 -> o2.value - o1.value }
        .run { IntArray(minOf(k, size)) { this[it].key } }

    private fun topKFrequentQueue(nums: IntArray, k: Int) = nums
        .countOccurrences(HashMap())
        .run {
            val deque = PriorityQueue(comparator)
            for (i in this) {
                deque.add(i.key)
                if (deque.size > k) deque.poll()
            }
            deque.toList()
        }

    override fun runProblem() = topKFrequent(testCases[1].first, testCases[1].second).toList()

    override val testCases = arrayOf(
        intArrayOf(2, 2, 2, 2, 2, 3, 3, 3, 5, 5, 4, 2, 1, 4, 5, 6, 7, 8, 4, 2, 3, 6, 5, 2, 4, 5, 6) to 3,
        intArrayOf(1, 1, 1, 2, 2, 3) to 2,
    )
}