object ValidSquare : Problem.Medium(593) {

    private fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        //AFTER SORTING, (ARR[0]/ARR[3]) AND (ARR[1]/ARR[2]) WILL ***ALWAYS*** BE DIAGONAL
        //AND ALL OTHER COMBOS ARE SIDES AND MUST BE EQUAL
        val p = arrayOf(p1, p2, p3, p4).sortIntPairs()

        //COMPARING DIAGONALS
        val diagonal1 = p[0].distanceTo(p[3])
        val diagonal2 = p[1].distanceTo(p[2])
        if (diagonal1 != diagonal2) return false

        //IF FIRST DISTANCE == 0 RETURN FALSE. REMAINING SIDES MUST EQUAL THE  FIRST ANYWAYS
        //COMPARING REMAINING SIDES
        val distance1 = p[0].distanceTo(p[1])
        val distance2 = p[1].distanceTo(p[3])
        val distance3 = p[0].distanceTo(p[2])
        val distance4 = p[3].distanceTo(p[2])

        return distance1 != 0 && distance1 == distance2 && distance2 == distance3 && distance3 == distance4
    }

    override fun runProblem() = validSquare(
        mainTestcase[0],
        mainTestcase[1],
        mainTestcase[2],
        mainTestcase[3],
    )

    override fun runTestCases() = testCases.map {
        "\n${it.getTestCase()}:  ${validSquare(it[0], it[1], it[2], it[3])}\n"
    }.print()

    override val mainTestcase get() = testCases[1]

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        ),
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 1)
        ),
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 12)
        ),
        arrayOf(
            intArrayOf(2, 4),
            intArrayOf(0, 2),
            intArrayOf(2, 0),
            intArrayOf(4, 2)
        )
    )
}