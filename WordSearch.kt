object WordSearch : Problem.Medium(79) {
    private fun exist(board: Array<CharArray>, word: String): Boolean {
        for (row in board.indices) {
            for (col in board[0].indices) {
                if (board[row][col] != word.first()) continue
                if (explore(board, word, row to col, 1, HashSet(word.length))) return true
            }
        }
        return false
    }

    private fun explore(
        board: Array<CharArray>, word: String, pair: Pair<Int, Int>, l: Int, visited: HashSet<Pair<Int, Int>>
    ): Boolean {
        if (l == word.length) return true
        repeat(4) { i ->
            val next = pair.first + DIRECTIONS[i] to pair.second + DIRECTIONS[i + 1]
            if (!board.isSafe(next.first, next.second, word[l]) || !visited.add(next)) return@repeat
            if (explore(board, word, next, l + 1, visited)) return true
            visited.remove(next)
        }
        return false
    }

    override val testCases = arrayOf(sample to "ABCCED", sample to "SEE", sample to "ABCB")
    override fun runTestCases() = testCases.map { exist(it.first, it.second) }.toString().print()
    override fun runProblem() = exist(testCases[0].first, testCases[0].second)
    private val sample
        get() = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
}