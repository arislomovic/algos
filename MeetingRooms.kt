object MeetingRooms : Problem.Easy(252) {
    private fun canAttendMeetings(intervals: Array<IntArray> = testCases[4]): Boolean {
        intervals.sortIntPairs()
        repeat(intervals.size - 1) { i -> if (intervals[i][1] > intervals[i + 1][0]) return false }
        return true
    }

    override fun runProblem() = canAttendMeetings(testCases[4])

    override val testCases = arrayOf(
        arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20)),
        arrayOf(intArrayOf(7, 10), intArrayOf(2, 4)),
        arrayOf(intArrayOf(0, 10), intArrayOf(11, 14), intArrayOf(0, 10)),
        arrayOf(intArrayOf(0, 1)),
        arrayOf(intArrayOf(9, 10), intArrayOf(4, 9), intArrayOf(4, 17)),
        arrayOf(intArrayOf(6, 15), intArrayOf(13, 20), intArrayOf(6, 17)),
        arrayOf(intArrayOf(6, 13), intArrayOf(13, 20)),
        arrayOf(intArrayOf(2, 15), intArrayOf(36, 45), intArrayOf(9, 29), intArrayOf(16, 23), intArrayOf(4, 9)),
        arrayOf(),
    )
}