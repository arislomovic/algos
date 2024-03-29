package grind75.easy

object TwoSums : Problem.Easy(1) {
    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (index in nums.indices) {
            map[target - nums[index]]?.let { return intArrayOf(it, index) }
            map[nums[index]] = index
        }
        return intArrayOf()
    }

    fun twoSumSortedArr(nums: IntArray = intArrayOf(2, 7, 11, 15), target: Int = 9): List<Pair<Int, Int>> {
        var end = nums.size - 1
        var start = 0
        val list = ArrayList<Pair<Int, Int>>()
        while (end >= start) {
            val sum = nums[start] + nums[end]
            when {
                start == end -> start++
                sum == target -> list.add(nums[start++] to nums[end--])
                sum > target -> end--
                else -> start++
            }
        }
        return list
    }

    override fun runProblem() = twoSum(mainTestcase.first, mainTestcase.second).toList()
    override val mainTestcase get() = testCases[0]
    override val testCases = arrayOf(
        intArrayOf(2, 7, 11, 15) to 9,
        intArrayOf(5, 1, 12, 17) to 17,
        intArrayOf(19, 7, 11, 15) to 30,
        intArrayOf(21, 72, 31, 45) to 52,
        intArrayOf(1, 2, 3, 4, 3) to 6,
        intArrayOf(1, 5, 3, 3, 3) to 6,
        intArrayOf(1, 5, 3, 3, 3, 6, 0) to 6
    )
}