object DailyTemperature : Problem.Easy(739) {
    private fun dailyTemperatures(temperatures: IntArray = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)): IntArray {
        if (temperatures.isEmpty()) return temperatures
        val size = temperatures.size
        val ans = IntArray(size)
        val stack: ArrayDeque<Int> = ArrayDeque()
        repeat(size) { i ->
            while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
                val stackNext = stack.removeLast()
                ans[stackNext] = i - stackNext
            }
            stack.addFirst(i)
        }
        return ans
    }

    override fun runProblem() = dailyTemperatures().getString()
}