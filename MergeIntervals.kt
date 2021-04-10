object MergeIntervals : Problem.Medium(56) {
    override fun runProblem() = merge(testCases[0])

    private fun merge(intervals: Array<IntArray>) = InsertInterval.insert(intervals, intArrayOf(-1, -1))

    override val mainTestcase get() = testCases[0]
    override val testCases = arrayOf(
        arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
        arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
        arrayOf(intArrayOf(1, 3), intArrayOf(3, 3), intArrayOf(8, 9), intArrayOf(0, 0), intArrayOf(1, 9))
    )
}