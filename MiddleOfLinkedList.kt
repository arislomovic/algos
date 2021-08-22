object MiddleOfLinkedList : Problem.Easy(876) {
    fun minDifficulty(dif: IntArray, d: Int): Int {
        val n = dif.size
        if (n < d) return -1

        val dp = Array(d) { IntArray(n) { Int.MAX_VALUE } }

        for (i in dp[0].indices) {
            dp[0][i] = dif.slice(0..i).maxOrNull()!!
        }

        for (day in 1 until d) {
            for (i in dp[day].indices) {
                for (j in 0 until i) {
                    val current = dp[day - 1][j]
                    if (current != Int.MAX_VALUE) {
                        dp[day][i] = maxOf(dp[day][i], current + dif.slice(j + 1..i).maxOrNull()!!)
                    }
                }
            }
        }
        return dp[d - 1][n - 1]
    }

    override val mainTestcase get() = testCases[0]
    override fun runProblem() = minDifficulty(mainTestcase.first, mainTestcase.second)
    override val testCases = arrayOf(
        intArrayOf(6, 5, 4, 3, 2, 1) to 2,
        intArrayOf(9, 9, 9) to 4,
        intArrayOf(1, 1, 1) to 3,
        intArrayOf(7, 1, 7, 1, 7, 1) to 3,
        intArrayOf(11, 111, 22, 222, 33, 333, 44, 444) to 6,
    )
}