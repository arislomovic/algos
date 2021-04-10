object PivotIndex : Problem.Easy(724) {
    private fun pivotIndex(nums: IntArray): Int {
        var rightSum = nums.sum()
        var leftSum = 0
        for (i in nums.indices) {
            rightSum-=nums[i]
            if (leftSum == rightSum) return i
            leftSum+= nums[i]
        }
        return -1
    }

    override fun runProblem() = pivotIndex(mainTestcase)
    override val mainTestcase get() = testCases[2]
    override val testCases = arrayOf(
        intArrayOf(1, 7, 3, 6, 5, 6),
        intArrayOf(1, 2, 3),
        intArrayOf(2, 1, -1)
    )
}