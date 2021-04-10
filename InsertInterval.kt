object InsertInterval : Problem.Medium(57) {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf(newInterval)
        val deque = ArrayDeque<IntArray>()
        for (interval in intervals) {
            if (newInterval[0] in interval[0]..interval[1] || newInterval[1] in interval[0]..interval[1]) {
                interval[0] = minOf(newInterval[0], interval[0])
                interval[1] = maxOf(newInterval[1], interval[1])
                newInterval[0] = -1
                newInterval[1] = -1
            }
            if (deque.isEmpty() || deque.last()[1] < interval[0]) deque.add(interval)
            else if (deque.last()[1] < interval[1]) deque.last()[1] = interval[1]
        }
        return deque.toTypedArray()
    }

    override fun runProblem() = insert(mainTestcase.first, mainTestcase.second)

    override val testCases = arrayOf(
        arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)) to intArrayOf(2, 5),
        arrayOf(intArrayOf()) to intArrayOf(5, 7),
        arrayOf(intArrayOf(1, 5)) to intArrayOf(2, 3),
        arrayOf(intArrayOf(1, 5)) to intArrayOf(2, 7),
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
                to intArrayOf(4, 8),
    )

    override val mainTestcase get() = testCases[4]

}