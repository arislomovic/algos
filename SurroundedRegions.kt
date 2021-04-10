object SurroundedRegions : Problem.Medium(130) {

    private const val X = 'X'
    private const val O = 'O'
    private fun solve(board: Array<CharArray>): Array<CharArray> {
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        for (row in 1 until board.size - 1) {
            for (col in 1 until board[0].size - 1) {
                if (!visited[row][col] && board[row][col] == O) onOFound(board, row, col, visited)
            }
        }
        return board
    }

    private fun onOFound(board: Array<CharArray>, row: Int, col: Int, all: Array<BooleanArray>) {
        val visited = HashSet<Pair<Int, Int>>(board.size * board[0].size).apply { add(row to col) }
        all[row][col] = true
        var valid = true
        bfs(row, col) { nextRow, nextCol ->
            if (!board.isSafe(nextRow, nextCol, O) || all[nextRow][nextCol]) false
            else {
                valid = valid && (nextRow == board.size - 1 || nextCol == board[0].size - 1)
                all[nextRow][nextCol] = true
                visited.add(nextRow to nextCol)
            }
        }
        if (!valid) return

        for (item in visited) {
            board[item.first][item.second] = X
        }
    }

    override val testCases = arrayOf(
        arrayOf(
            charArrayOf(X, X, X, X),
            charArrayOf(X, O, O, X),
            charArrayOf(X, X, O, X),
            charArrayOf(X, O, X, X)
        ),
        arrayOf(
            charArrayOf(X)
        )
    )

    override val mainTestcase = testCases[0]
    override fun runProblem() = solve(mainTestcase)
}