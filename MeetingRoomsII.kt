import java.util.*


object MeetingRoomsII : Problem.Medium(252) {

    private fun minMeetingRoomsChronological(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        val startTimes = IntArray(intervals.size) { intervals[it][0] }.sortInPlace()
        val endTimes = IntArray(intervals.size) { intervals[it][1] }.apply { sort() }

        var endIndex = 0
        var usedRooms = 0

        for (startTime in startTimes) {
            if (startTime < endTimes[endIndex]) usedRooms++
            else endIndex++
        }

        return usedRooms
    }

    private fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortIntPairs()
        val allocator = PriorityQueue(intervals.size, comparator)
        for (interval in intervals) {
            if (allocator.isNotEmpty() && interval[0] >= allocator.peek()) allocator.poll()
            allocator.add(interval[1])
        }
        return allocator.size
    }

    override fun runProblem() = minMeetingRoomsChronological(testCases[7])

    override val testCases = MeetingRooms.testCases
}