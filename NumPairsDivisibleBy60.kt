object NumPairsDivisibleBy60 : Problem.Medium(1010) {
    override fun runProblem() = numPairsDivisibleBy60()

    private fun numPairsDivisibleBy60(time: IntArray = testCases[0]): Int {
        val remainders = HashMap<Int, Int>()
        var count = 0
        for (t in time) {
            val remainder = t % 60
            val index = if (remainder == 0) 0 else 60 - remainder
            count += remainders.getOrDefault(index, 0)
            remainders[remainder] = remainders.getOrDefault(remainder, 0) + 1
        }
        return count
    }

    override val testCases = arrayOf(
            intArrayOf(30, 20, 150, 100, 40),
            intArrayOf(60, 60, 60),
            intArrayOf(15, 63, 451, 213, 37, 209, 343, 319)
    )
}