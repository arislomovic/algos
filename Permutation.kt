object Permutation : Problem.Hard(46) {
    override fun runProblem() = intArrayOf(1, 2, 3, 4, 5).apply { permute(this) }.toList()
    private fun permute(nums: IntArray): List<List<Int>> = backTrack(nums.toList(), listOf(), arrayListOf())
    private fun backTrack(nums: List<Int>, current: List<Int>, all: ArrayList<List<Int>>): ArrayList<List<Int>> {
        if (nums.isEmpty()) return all.apply { add(current) }
        for (i in nums.indices) {
            val newNum = ArrayList(nums).apply { removeAt(i) }
            backTrack(newNum, current, all)
        }
        return all
    }
}
