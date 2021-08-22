object Fibonacci : Problem.Easy(509) {
    override fun runProblem() = fib(3)

    private fun fib(n: Int): Int {
        val cache = IntArray(n + 1) { it }
        for (index in 2..n) cache[index] = cache[index - 1] + cache[index - 2]
        return cache[n]
    }
}
