import kotlin.math.abs

object GameOfLife : Problem.Medium(289) {
    private fun gameOfLife(board: Array<IntArray>): Array<IntArray> {
        val answers = ArrayList<Triple<Int, Int, Int>>()
        board.gameOfLifeInternal { x, y, ok -> answers.add(Triple(x, y, if (ok) 1 else 0)) }
        for (a in answers) board[a.first][a.second] = a.third
        return board
    }

    private fun Array<IntArray>.gameOfLifeInternal(s1: (x: Int, y: Int, ok: Boolean) -> Unit) {
        for (row in indices) {
            for (col in this[row].indices) {
                val neighbors = countLivingNeighbors(this, row, col)
                if (neighbors != 3 && neighbors != 2 && this[row][col] == 1) s1.invoke(row, col, false)
                else if (neighbors == 3 && this[row][col] == 0) s1.invoke(row, col, true)
            }
        }
    }

    private fun gameOfLifeConstantSpace(board: Array<IntArray>): Array<IntArray> {
        board.gameOfLifeInternal { x, y, ok -> board[x][y] += if (ok) 2 else -2 }
        for (row in board.indices) {
            for (col in board[row].indices) {
                board[row][col] = if (board[row][col] <= 0) 0 else 1
            }
        }
        return board
    }

    private fun countLivingNeighbors(board: Array<IntArray>, row: Int, col: Int): Int {
        var counter = 0
        repeat(3) { i ->
            for (j in (if (i == 0) 1 else 0) until 3) {
                val new = row + ALL_DIRECTIONS[i] to col + ALL_DIRECTIONS[j]
                if (board.isSafe(new.first, new.second) && abs(board[new.first][new.second]) == 1) counter++
            }
        }
        return counter
    }

    override fun runProblem() = gameOfLifeConstantSpace(testCases[0]).getArrayString()

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        ),
        arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
    )
}