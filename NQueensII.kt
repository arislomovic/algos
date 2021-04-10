import kotlin.math.abs

object NQueensII : Problem.Hard(52) {
    override fun runProblem() = totalNQueens()
    private fun totalNQueens(n: Int = 4): Int {
        val sets: ArrayList<IntArray> = ArrayList()
        findNextMove(n, sets = sets)
        return sets.size
    }

    private fun findNextMove(n: Int, row: Int = 0, sets: ArrayList<IntArray>, board: IntArray = IntArray(n)) {
        if (row == n) return run { sets.add(board) }
        repeat(n) { col ->
            board[row] = col
            if (isValidPlacement(board, row)) findNextMove(n, row + 1, sets, board)
        }
    }

    private fun isValidPlacement(board: IntArray, row: Int): Boolean {
        repeat(row) { i ->
            val columnDiff = board[row] - board[i]
            //IF THE ABSOLUTE VALUE OF RISE/RUN == 1 OR -1) THEN ITEM IS IN DIAGONAL RISK
            //THIS CAN BE EXPRESSED AS "abs((row-i)/(board[row] - board[i])) == 1"
            //OR MORE SIMPLY... row - i == abs(board[row] - board[i]
            if (board[row] == board[i] || row - i == abs(columnDiff)) return false
        }
        return true
    }

}