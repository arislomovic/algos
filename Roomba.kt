object Roomba : Problem.Hard(489) {

    override fun runProblem() = cleanRoom().toString()
    private fun cleanRoom(robot: Robot = Robot(testCases, 1 to 3)): Robot {
        moveAndBackTrack(robot, 0 to 0, 0, hashSetOf())
        return robot
    }

    private fun goBack(robot: Robot) {
        robot.turnLeft().turnLeft()
        robot.move()
        robot.turnLeft().turnLeft()
    }

    private fun moveAndBackTrack(robot: Robot, xy: Pair<Int, Int>, direction: Int, visited: HashSet<Pair<Int, Int>>) {
        if (!visited.add(xy)) return
        robot.clean()
        repeat(4) { i ->
            val directionIndex = (direction + i) % 4
            val newXY = xy.first + DIRECTIONS[directionIndex] to xy.second + DIRECTIONS[directionIndex + 1]
            if (robot.move()) {
                moveAndBackTrack(robot, newXY, directionIndex, visited)
                goBack(robot)
            }
            robot.turnRight()
        }
    }

    override val testCases = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 0, 1, 1),
        intArrayOf(1, 1, 1, 1, 1, 0, 1, 1),
        intArrayOf(1, 0, 1, 1, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
    )
}