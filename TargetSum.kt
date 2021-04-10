object TargetSum : Problem.Medium() {
    override fun runProblem() = add(intArrayOf(1, 2, 3, 5), 5)
    private fun findTargetSumWays(nums: IntArray, S: Int) = addRecursive(nums, 0, 0, S)

    private fun addRecursive(nums: IntArray, total: Int, index: Int, S: Int): Int =
        when {
            index != nums.size -> addRecursive(nums, total + nums[index], index + 1, S) +
                    addRecursive(nums, total - nums[index], index + 1, S)
            total == S -> 1
            else -> 0
        }

    private fun add(nums: IntArray, total: Int): Int {
        if (nums.isEmpty()) return 0
        var counter = 0
        val stack = arrayDequeOf(0)
        val numSize = nums.size - 1
        for (i in 0..numSize) {
            val size = stack.size
            repeat(size) {
                val diff = stack.last() - nums[i]
                val add = stack.removeLast() + nums[i]
                if (i == numSize) {
                    if (add == total || diff == total) counter++
                    return@repeat
                }
                stack.addFirst(diff)
                stack.addFirst(add)
            }
        }
        return counter
    }
}

