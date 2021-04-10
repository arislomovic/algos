object MissingPositive : Problem.Hard(41) {
    private fun firstMissingPositive(nums: IntArray = mainTestcase): Int {
        var counter = 1
        for (num in nums.toSortedSet()) {
            if (num == counter) counter++
            else if (num >= 0) return counter
        }
        return counter
    }


    private fun firstMissingPositiveConstantSpace(nums: IntArray = mainTestcase): Int {

        repeat (nums.size) {
            //Putting everything in the right place only if 1 <= num <= nums.size. Otherwise we ignore
            if (nums[it] in 1..nums.size) nums.swap(it, nums[it] - 1)
        }

        repeat (nums.size) {
            if (nums[it] != it + 1) return it + 1
        }
        return nums.size + 1
    }

    override fun runProblem() = firstMissingPositiveConstantSpace()

    override val mainTestcase get() = testCases[1]

    override val testCases = arrayOf(
            intArrayOf(1, 2, 0),
            intArrayOf(3, 4, -1, 1),
            intArrayOf(7, 8, 9, 11, 12),
            intArrayOf(0, 2, 2, 1, 1),
            intArrayOf(0, 2, 4, 3, 1),
    )
}