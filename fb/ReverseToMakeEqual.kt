package fb

object ReverseToMakeEqual : Problem.Misc() {
    private fun areTheyEqual(a: IntArray, b: IntArray): Boolean {
        var start = 0
        var end = b.size - 1
        if (start == end) return a[start] == b[start]
        while (start < end && a[start] == b[start]) {
            start++
        }
        if (start == end) return a[start] == b[start]
        while (end >= start && a[end] == b[end]) {
            end--
        }
        if (start == end) return a[start] == b[start]
        while (end >= start) {
            if (a[start] != b[end] || b[start] != a[end]) return false
            start++
            end--
        }
        return a[end] == b[start]
    }

    override fun runProblem() = areTheyEqual(mainTestcase.first, mainTestcase.second)
    override fun runTestCases() = testCases.map { areTheyEqual(it.first, it.second) }
    override val mainTestcase get() = testCases[4]
    override val testCases =
        arrayOf(
            intArrayOf(1,0,0,0,0,1) to intArrayOf(1,0,0,0,0,1),
            intArrayOf(1,0,0,0,0,1) to intArrayOf(1,1,0,0,0,0),
            intArrayOf(0, 1) to intArrayOf(1, 0),
            intArrayOf(1, 0, 1) to intArrayOf(1, 0, 0),
            intArrayOf(1, 0, 1) to intArrayOf(1, 0, 1),
            intArrayOf(1, 2, 3, 4) to intArrayOf(1, 4, 3, 2),
            intArrayOf(1, 2, 3, 4) to intArrayOf(1, 3, 3, 2),
            intArrayOf(1) to intArrayOf(1),
            intArrayOf(0) to intArrayOf(1),
        )
}