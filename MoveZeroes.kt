object MoveZeroes : Problem.Easy(283) {

    private fun moveZeroes(nums: IntArray):List<Int> {
        var nonZeroIndex = 0
        for (cur in nums.indices) {
            if (nums[cur] != 0) {
                nums.swap(nonZeroIndex++, cur)
            }
        }
        return nums.toList()
    }

    override val testCases = arrayOf(
        intArrayOf(0, 1, 0, 3, 12),
        intArrayOf(1, 3, 0, 12),
        intArrayOf(0),
        intArrayOf(9, 3, 9, 4, 5, 4, 8, 3, 7),
        intArrayOf(1, 0, 9, 0, 5, 0, 8, 0, 7),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 3, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 3),
    )
    override val mainTestcase = testCases[0]
    override fun runProblem() = moveZeroes(mainTestcase)
    override fun runTestCases() = testCases.map { moveZeroes(it) }
}