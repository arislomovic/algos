import java.util.*

object KClosest : Problem.Medium(973) {
    private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val queue = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o2.second - o1.second }
        repeat(points.size) {
            queue.add(it to points[it].distanceTo(0, 0))
            if (queue.size > k) queue.poll()
        }
        return Array(k) { if (queue.isEmpty()) intArrayOf() else points[queue.poll().first] }
    }

    private fun kClosestSort(points: Array<IntArray>, k: Int): Array<IntArray> {
        Arrays.sort(points) { o1, o2 -> o1.distanceTo(0, 0) - o2.distanceTo(0, 0) }
        return Array(k) { points[it] }
    }

    override fun runProblem() = kClosestSort(mainTestcase.first, mainTestcase.second).map { it.toList() }

    override val mainTestcase get() = testCases[0]

    override fun runTestCases() = testCases.map { kClosest(it.first, it.second).getTestCase() }

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(-2, 2),
            intArrayOf(1, 3),
        ) to 1,
        arrayOf(
            intArrayOf(3, 3),
            intArrayOf(5, -1),
            intArrayOf(-2, 4),
        ) to 2
    )
}