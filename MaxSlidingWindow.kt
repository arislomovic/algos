object MaxSlidingWindow : Problem.Hard(239) {
    private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        for (i in 1 until nums.size) nums[i] = maxOf(nums[i], nums[i - 1])
        return if (nums.size == k)  intArrayOf(nums.last())
        else  IntArray(nums.size - (k - 1)) { nums[(k - 1) + it] }
    }

    override fun runProblem() = maxSlidingWindow(mainTestcase.first, mainTestcase.second)
    override fun runTestCases() = testCases.map { maxSlidingWindow(it.first, it.second).toList() }.toString()
    override val mainTestcase get() = testCases[0]
    override val testCases = arrayOf(
        intArrayOf(1, 3, -1, -3, 5, 3, 6, 7) to 3,
        intArrayOf(1) to 1,
        intArrayOf(1, -1) to 1,
        intArrayOf(9, 11) to 2,
        intArrayOf(4, -2) to 2,
    )
}