object SearchRotatedSortedArray : Problem.Medium(33) {
    private fun search(nums: IntArray, target: Int): Int {
        var pivotIndex = nums.size - 1
        while (pivotIndex > 0 && nums[pivotIndex - 1] < nums[pivotIndex]) {
            if (nums[pivotIndex] == target) return pivotIndex
            if (nums[--pivotIndex] == target) return pivotIndex
        }
        pivotIndex--
        var low = 0
        while (low < pivotIndex) {
            val mid = (low + pivotIndex) / 2
            when {
                nums[low] == target -> return low
                nums[pivotIndex] == target -> return pivotIndex
                nums[low] < nums[mid] -> low = mid + 1
                else -> pivotIndex = mid - 1
            }
        }
        return -1
    }

    override val testCases = arrayOf(
        intArrayOf(4,5,6,7,0,1,2) to 3,
        intArrayOf(4,5,6,7,0,1,2) to 0,
        intArrayOf(1) to 0
    )

    override fun runTestCases() = testCases.map { search(it.first, it.second) }.toString().print()

    override fun runProblem() = search(testCases[0].first, testCases[0].second)
}