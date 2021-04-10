object ProductOfArrayExceptSelf : Problem.Medium(238) {
    override fun runProblem() = productExceptSelf()
    private fun productExceptSelf(nums: IntArray = testCases[1]): IntArray {
        val length = nums.size
        val left = IntArray(length).apply { this[0] = 1 }
        val right = IntArray(length).apply { this[length - 1] = 1 }
        for (i in 1 until length) {
            left[i] = nums[i - 1] * left[i - 1]
            right[length - i - 1] = right[length - i] * nums[length - i]
        }

        return IntArray(length) { left[it] * right[it] }
    }


    override val testCases = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(3, 1, 2, 1),
            intArrayOf(3, 1, 1, 2),
            intArrayOf(2, 5, 9, 11),
            intArrayOf(3, 11, 21, 1),
    )
}