
object SubArraySum : Problem.Medium(560) {
    private fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        repeat(nums.size) {
            var sum = 0
            for (end in it until nums.size) {
                sum += nums[end]
                if (sum == k) count++
            }
        }
        return count
    }

    override val mainTestcase get() = testCases[1]
    override fun runProblem() = subarraySum(mainTestcase.first, mainTestcase.second)

    override val testCases = arrayOf(
        intArrayOf(1, 1, 1) to 2,
        intArrayOf(1, 2, 3) to 3
    )

}