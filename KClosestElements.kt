import kotlin.math.abs

object KClosestElements : Problem.Medium(658) {
    private fun findClosestElemens(arr: IntArray, k: Int, x: Int) =
        arr.sortedWith { o1, o2 -> abs(o1 - x) - abs(o2 - x) }.take(k).sorted()

    private fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var sum = 0
        repeat (k) {
            sum += arr[it]
        }
        val averageDifference = { abs(sum.toDouble() / k.toDouble() - x.toDouble()) }
        var closestIndex = k to averageDifference()
        for(counter in k until arr.size) {
            sum -= arr[counter - k] + arr[counter]
            averageDifference().run { if (closestIndex.second > this) closestIndex = counter to this }
        }
        return arr.slice(closestIndex.first - k until closestIndex.first)
    }

    fun findClosestElementsBinary(arr: IntArray, k: Int, x: Int): List<Int> {
        var left = 0
        var right = arr.size - k
        while (left < right) {
            val midpoint = left + (right - left) / 2
            if (x - arr[midpoint] <= arr[midpoint + k] - x) right = midpoint
            else left = midpoint + 1
        }
        return arr.slice(left until left + k)
    }

    override fun runProblem() = findClosestElements(mainTestcase.first, mainTestcase.second, mainTestcase.third)

    override val mainTestcase get() = testCases[0]

    override fun runTestCases() = testCases.map { findClosestElements(it.first, it.second, it.third) }
    override val testCases = arrayOf(
        Triple(intArrayOf(1, 2, 3, 4, 5), 4, 3),
        Triple(intArrayOf(1, 2, 3, 4, 5), 4, -1)
    )

}