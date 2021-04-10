object RotateImage : Problem.Medium(48) {
    private fun rotate(matrix: Array<IntArray> = testCases[1]): Array<IntArray> {
        if (matrix.size < 2) return matrix
        var end = matrix.size - 1
        var start = 0
        while (start <= end) matrix.swap(start++, end--)
        for (i in matrix.indices) {
            for (j in i + 1 until matrix.size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        return matrix
    }

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16)
        ),
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        ),
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        ),
        arrayOf(
            intArrayOf(1)
        )
    )

    override fun runProblem() = testCases[1].getArrayString() + rotate().getArrayString()

    override fun runTestCases() = testCases.map { rotate(it).toList() }
}