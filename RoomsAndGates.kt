object RoomsAndGates : Problem.Medium(286) {
//You are given a m x n 2D grid initialized with these three possible values.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//-1 - A wall or an obstacle.
// 0 - A gate.
//INF (2147483647) - Infinity means an empty room.

    private const val GATE = 0
    private const val INF = 2147483647
    private const val WALL = -1

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(INF, WALL, GATE, INF),
            intArrayOf(INF, INF, INF, WALL),
            intArrayOf(INF, WALL, INF, WALL),
            intArrayOf(GATE, WALL, INF, INF)
        ),
        arrayOf(intArrayOf(WALL)),
        arrayOf(intArrayOf(INF)),
        arrayOf(intArrayOf(GATE)),
    )

    private fun wallsAndGates(rooms: Array<IntArray>): Array<IntArray> {
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        for (row in rooms.indices) {
            for (col in rooms[0].indices) {
                if (rooms[row][col] == GATE) queue.addLast(row to col)
            }
        }
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            repeat(4) { i ->
                val next = current.first + DIRECTIONS[i] to current.second + DIRECTIONS[i + 1]
                if (!rooms.isSafe(next.first, next.second, INF)) return@repeat
                rooms[next.first][next.second] = rooms[current.first][current.second] + 1
                queue.addLast(next)
            }
        }
        return rooms
    }

    override fun runTestCases() = testCases.map {
        wallsAndGates(it).getArrayString()
    }.print()

    override fun runProblem() = wallsAndGates(testCases[0]).getArrayString()

}