import java.util.ArrayList


object SpiralMatrix : Problem.Medium(54) {
    private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) return listOf()
        val ans = ArrayList<Int>()
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1
        while (top <= bottom && left <= right) {
            //add top row
            for (column in left..right) ans.add(matrix[top][column])
            //add right column
            for (row in top + 1..bottom) ans.add(matrix[row][right])
            if (top < bottom && left < right) {
                //add bottom row
                for (column in right - 1 downTo left + 1) ans.add(matrix[bottom][column])
                //add left column
                for (row in bottom downTo top + 1) ans.add(matrix[row][left])
            }
            top++
            bottom--
            left++
            right--
        }
        return ans
    }

    override fun runProblem() = spiralOrder(testCases[0])

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
    )

}