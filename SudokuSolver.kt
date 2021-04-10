object SudokuSolver : Problem.Medium() {

    override fun runProblem() = with(sudokuBoard) {
        solveSudoku(this)
        map { it.toList().toString() + "\n" }
    }

    private fun solveSudoku(board: Array<CharArray>): Boolean {
        val size = board.size
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (board[i][j] == '.') return search(board, i, j)
            }
        }
        return true
    }

    private fun search(board: Array<CharArray>, row: Int, col: Int): Boolean {
        for (num in 1..board.size) {
            if (!board.isSafe(row, col, '0' + num)) continue
            board[row][col] = '0' + num
            if (solveSudoku(board)) return true
            else board[row][col] = '.'
        }
        return false
    }

    private fun Array<CharArray>.isSafe(x: Int, y: Int, c: Char): Boolean {
        for (d in indices) {
            if (this[x][d] == c || this[d][y] == c) return false
        }
        for (r in 0 until 3) {
            for (d in 0 until 3) {
                if (this[r + (x - x % 3)][d + (y - y % 3)] == c) return false
            }
        }
        return true
    }


    private val sudokuBoard
        get() = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
}