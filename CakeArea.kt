object CakeArea : Problem.Medium(1465) {
    private fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()
        var maxH = maxOf(horizontalCuts[0], h - horizontalCuts.last())
        var maxW = maxOf(verticalCuts[0], w - verticalCuts.last())
        repeat(verticalCuts.size - 1) { i ->
            maxW = maxOf(maxW, verticalCuts[i + 1] - verticalCuts[i])
        }

        repeat(horizontalCuts.size - 1) { i ->
            maxH = maxOf(maxH, horizontalCuts[i + 1] - horizontalCuts[i])
        }
        return maxW * maxH
    }

    override fun runProblem() = maxArea(5, 4, intArrayOf(3, 1), intArrayOf(1))
}