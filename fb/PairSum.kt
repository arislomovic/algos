package fb

object PairSum : Problem.Misc() {
    private fun getPairsCount(arr: IntArray, sum: Int): Int {
        val hm = HashMap<Int, Int>()
        for (i in arr) hm[i] = hm.getOrDefault(i, 0) + 1

        var twiceCount = 0

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (i in arr) {
            twiceCount += hm.getOrDefault(sum - i, 0)

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum - i == i) twiceCount--
        }

        // return the half of twice_count
        return twiceCount / 2
    }

    override fun runProblem() = getPairsCount(mainTestcase.first, mainTestcase.second)
    override val mainTestcase get() = testCases.last()
    override val testCases = TwoSums.testCases
}