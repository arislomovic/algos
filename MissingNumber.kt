object MissingNumber : Problem.Easy(268) {
    private fun missingNumber(nums: IntArray) = nums.size.run { (this * (this + 1)) / 2 } - nums.sum()
    override val mainTestcase get() = testCases[0]
    override fun runProblem() = missingNumber(mainTestcase)
    override val testCases = arrayOf(
        intArrayOf(3, 0, 1),
        intArrayOf(0, 1),
        intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1),
        intArrayOf(0)
    )
}