import kotlin.math.max

object CakeArea : Problem.Medium(1465) {
    private fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val maxH = maxCut(horizontalCuts, h)
        val maxW = maxCut(verticalCuts, w)
        val area = (maxH * maxW) % 1000000007L
        return area.toInt()
    }

    private fun maxCut(cuts: IntArray, h: Int): Int {
        cuts.sort()
        var max = max(cuts[0], h - cuts.last())
        repeat(cuts.size - 1) {
            max = maxOf(cuts[it + 1] - cuts[it], max)
        }
        return max
    }

    override fun runProblem() = maxArea(5, 4, intArrayOf(3, 1), intArrayOf(1))
}