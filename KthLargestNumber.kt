import java.util.*


object KthLargestNumber : Problem.Medium(215) {

    private fun findKthLargestMap(nums: IntArray, k: Int): Int {
        val map = nums.countOccurrences(TreeMap(comparator))
        var count = k
        for (entry in map) {
            count -= entry.value
            if (count <= 0) return entry.key
        }
        return -1
    }

    private fun findKthLargest(nums: IntArray, k: Int): Int {
        val q = PriorityQueue(comparator)
        for (n in nums) {
            q.add(n)
            if (q.size > k) q.poll()//Remove Lowest (Last)
        }
        return q.poll()
    }

    override val testCases = arrayOf(
        intArrayOf(3, 2, 1, 5, 6, 4) to 2, //5
        intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6) to 4 //4
    )

    override fun runProblem() = findKthLargest(testCases[0].first, testCases[0].second)
}