object ClimbingStairs : Problem.Easy(70) {
    override fun runProblem() = climbStairs(10)
    private fun climbStairs(n: Int): Int {
        val cache = IntArray(n + 1) { it }
        for (i in 4..n) cache[i] = cache[i - 1] + cache[i - 2]
        return cache[n]
    }
}