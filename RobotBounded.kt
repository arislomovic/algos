object RobotBounded : Problem.Medium(1041) {
    private fun isRobotBounded(instructions: String): Boolean {
        var direction = 0
        val map = IntArray(4) { -1 }
        for (i in instructions) {
            when (i) {
                'G' -> map[direction]++
                'L' -> direction = (direction + 3) % 4
                'R' -> direction = (direction + 1) % 4
            }
        }
        return direction != 0 || (map[0] == map[2] && map[1] == map[3])
    }
    private fun isRobotBoundedDirection(instructions: String = mainTestcase): Boolean {
        var position = 0 to 0
        var direction = 0
        for (i in instructions) {
            when (i) {
                'L' -> direction = (direction + 3) % 4
                'R' -> direction = (direction + 1) % 4
                else -> {
                    val mDirection = DIRECTIONS[direction] to DIRECTIONS[direction + 1]
                    position = position.first + mDirection.first to position.second + mDirection.second
                }
            }
        }

        return position.first == 0 && position.second == 0 || direction != 0
    }

    override val testCases = arrayOf(
        "GGLLGG", "GG", "GL"
    )

    override val mainTestcase get() = testCases[2]
    override fun runProblem() = isRobotBounded(mainTestcase)

}