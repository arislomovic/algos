object OpenLock : Problem.Medium(752) {
    //You have a lock with 4 circular wheels, each having 10 slots: '0','1','2','3','4','5','6','7','8','9'. The wheels
    // can rotate freely and wrap around: we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one
    // wheel one slot. The lock initially starts at '0000'. You're given a list of dead ends, meaning if the lock
    // displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it. Given a
    // target combination, return the minimum number of turns required to open the lock, or -1 if impossible.
    private fun openLock(deadEnds: Array<String> = testCases[0].first, target: String = testCases[0].second): Int {
        var rotations = 0
        val visited: HashSet<String> = deadEnds.toHashSet().apply { add("0000") }
        val queue = arrayDequeOf("0000")
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val lockPosition = queue.removeFirst().apply { if (this == target) return rotations }
                repeat(4) { i ->
                    build(lockPosition, i, if (lockPosition[i] == '9') '0' else (lockPosition[i] + 1), visited, queue)
                    build(lockPosition, i, if (lockPosition[i] == '0') '9' else (lockPosition[i] - 1), visited, queue)
                }
            }
            rotations++
        }
        return -1
    }

    private fun build(s: String, i: Int, c: Char, deadEnds: HashSet<String>, q: ArrayDeque<String>) {
        (s.substring(0, i) + c + s.substring(i + 1)).let { if (deadEnds.add(it)) q.addLast(it) }
    }

    override val testCases = arrayOf(arrayOf("0201", "0101", "0102", "1212", "2002") to "0202")

    override fun runProblem() = openLock()
}
