object TwoDMatrixSearchII : Problem.Medium() {

    override fun runProblem() = searchMatrixBinary(array, 8)

    private fun searchMatrixBinary(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false

        val shorterSide = minOf(matrix.size, matrix[0].size)
        repeat(shorterSide) { i->
            if (binarySearch(matrix, target, i, true)) return true
            if (binarySearch(matrix, target, i, false)) return true
        }
        return false
    }

    private fun searchMatrixSpaceReduction(matrix: Array<IntArray>, target: Int): Boolean {
        // start our "pointer" in the bottom-left
        val columnSize = matrix[0].size
        var row: Int = matrix.size - 1
        var col = 0
        while (row >= 0 && col < columnSize) {
            when {
                matrix[row][col] > target -> row--
                matrix[row][col] < target -> col++
                else -> return true
            }
        }
        return false
    }

    private fun binarySearch(matrix: Array<IntArray>, target: Int, start: Int, isColumn: Boolean): Boolean {
        var high = matrix.size - 1
        var lo = start
        if (isColumn) return matrix[start].binSearch(target)
        while (high > lo) {
            val mid = (high + lo) / 2
            if (matrix[mid][start] == target) return true
            if (matrix[mid][start] > target) lo = mid + 1
            else high = mid - 1
        }
        return false
    }


    private val array = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30)
    )

    private val array3 = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(11, 12, 13, 14, 15),
        intArrayOf(16, 17, 18, 19, 20),
        intArrayOf(21, 22, 23, 24, 25)
    )

    private val array1 = arrayOf(intArrayOf(1))
    private val array100 = Array(10) { row -> IntArray(10) { col -> row * 10 + col + 1 } }


    private fun searchRect(matrix: Array<IntArray>, target: Int, left: Int, up: Int, right: Int, down: Int)
            : Boolean {
        if (left > right || up > down || target < matrix[up][left] || target > matrix[down][right]) return false
        val mid = left + (right - left) / 2
        var row = up
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row++][mid] == target) return true
        }
        return searchRect(matrix = matrix, target = target, left = left, up = row, right = mid - 1, down = down) ||
                searchRect(matrix = matrix, target = target, left = mid + 1, up = up, right = right, down = row - 1)
    }

    private fun searchMatrix1(matrix: Array<IntArray>, target: Int) = if (matrix.isEmpty()) false
    else searchRect(matrix, target, 0, 0, matrix[0].size - 1, matrix.size - 1)

}