object MaximumPoints : Problem.Medium(1423) {
    private fun maxScore(cardPoints: IntArray, k: Int): Int {

        if (k == cardPoints.size) return cardPoints.sum()

        var currentSum = 0

        repeat(k) {  i-> currentSum += cardPoints[i] }

        var max = currentSum

        repeat(k) { i ->
            currentSum += cardPoints[cardPoints.size - i - 1] - cardPoints[k - i - 1]
            max = maxOf(max, currentSum)
        }

        return max
    }

    override fun runProblem() = maxScore(testCases[0].first, testCases[0].second)

    override fun runTestCases() = testCases.map { maxScore(it.first, it.second) }.print()

    override val testCases = arrayOf(
        intArrayOf(1, 2, 3, 4, 5, 6, 1) to 3,
        intArrayOf(2, 2, 2) to 2,
        intArrayOf(9, 7, 7, 9, 7, 7, 9) to 7,
        intArrayOf(1, 1000, 1) to 1,
        intArrayOf(1, 79, 80, 1, 1, 1, 200, 1) to 3,
        intArrayOf(96, 90, 41, 82, 39, 74, 64, 50, 30) to 8,
    )
}