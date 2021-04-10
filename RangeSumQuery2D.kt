object RangeSumQuery2D : Problem.Medium(304) {
    class NumMatrix(val matrix: Array<IntArray>) {


        //Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)

        private var dp: Array<IntArray> = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

        init {
            repeat(matrix.size) { r ->
                repeat(matrix[0].size) { c ->
                    dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c]
                }
            }
        }

        fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]
        }
    }

    override val mainTestcase get() = testCases[0]

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(3, 0, 1, 4, 2),
            intArrayOf(5, 6, 3, 2, 1),
            intArrayOf(1, 2, 0, 1, 5),
            intArrayOf(4, 1, 0, 1, 7),
            intArrayOf(1, 0, 3, 0, 5)
        )
    )
}