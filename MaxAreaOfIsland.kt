object MaxAreaOfIsland : Problem.Medium(695) {
    private fun maxAreaOfIsland(grid: Array<IntArray>) = grid.bfs().second
    override fun runProblem() = maxAreaOfIsland(testCases.last())
    override val testCases = with(CountingIslands.testCases) {
        Array(size) { case -> Array(this[case].size) { arr -> this[case][arr].toIntArray() } }
    }
}