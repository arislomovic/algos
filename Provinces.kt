object Provinces : Problem.Medium(547) {

    private fun findCircleNum(grid: Array<IntArray>) = grid.bfs().first

    override val mainTestcase get() = testCases[0]
    override fun runProblem() = findCircleNum(mainTestcase)
    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        ),
        arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        ),
        arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 0, 1)
        ),
        arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 0, 0, 1)
        ),
    )
}