object MissingPositive : Problem.Hard(41) {
    private fun firstMissingPositive(nums: IntArray = testCases[3]): Int {
        var counter = 1
        for (num in nums.toSortedSet()) {
            if (num == counter) counter++
            else if (num >= 0) return counter
        }
        return counter
    }


    private fun firstMissingPositiveConstantSpace(nums: IntArray = testCases[4]): Int {

        for (i in nums.indices) {
            val num = nums[i]
            //Putting everything in the right place only if 1 <= num <= nums.size. Otherwise we ignore
            if (num in 1..nums.size) nums.swap(i, num - 1)
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) return i + 1
        }
        return nums.size + 1
    }

    override fun runProblem() = firstMissingPositiveConstantSpace()

    override val testCases = arrayOf(
            intArrayOf(1, 2, 0),
            intArrayOf(3, 4, -1, 1),
            intArrayOf(7, 8, 9, 11, 12),
            intArrayOf(0, 2, 2, 1, 1),
            intArrayOf(0, 2, 4, 3, 1),
    )
}