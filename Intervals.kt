object Intervals : Problem.Medium(56) {
    override fun runProblem() = merge(testCases[0])

    private fun merge(intervals: Array<IntArray> = testCases[0]): Array<IntArray> {
        intervals.sortIntPairs()
        val merged = ArrayDeque<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || merged.last()[1] < interval[0]) merged.addLast(interval)
            else if (merged.last()[1] < interval[1]) merged.last()[1] = interval[1]
        }
        return merged.toTypedArray()
    }

    override val testCases = arrayOf(
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
            arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
            arrayOf(intArrayOf(1, 3), intArrayOf(3, 3), intArrayOf(8, 9), intArrayOf(0, 0), intArrayOf(1, 9))
    )
}