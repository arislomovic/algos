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

    private fun productExceptSelfON(nums: IntArray): IntArray {
        var product = 1
        var zeroIndex = -1
        val answer = IntArray(nums.size)
        for (i in nums.indices) {
            when {
                nums[i] != 0 -> product *= nums[i]
                zeroIndex != -1 -> return answer
                else -> zeroIndex = i
            }
        }

        if (zeroIndex != -1) return answer.apply { this[zeroIndex] = product }
        for (i in nums.indices) answer[i] = product / nums[i]
        return answer
    }


    override val testCases = arrayOf(
        intArrayOf(1, 2, 3, 4), // 24 (24, 12, 8, 6)
        intArrayOf(3, 1, 2, 1),
        intArrayOf(3, 1, 1, 2),
        intArrayOf(2, 5, 9, 11),
        intArrayOf(2, 5, 0, 11),
        intArrayOf(0, 5, 0, 11),
        intArrayOf(3, 11, 21, 1),
    )
}