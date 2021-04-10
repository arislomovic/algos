package az

object ConnectionCost : Problem.Misc() {
    private fun connectionCost(connections: Array<CharArray>, num: Int): Int {
        val map = Array<Pair<Char, Int>>(26) { ' ' to -1 }
        for (connection in connections) {
            val cost = connection[2] - '0'
            val c1 = connection[0] - '0'
            val c2 = connection[1] - '0'
            if (map[c1].second > -1 && map[c2].second > -1) {

                continue
            }
        }
        var sum = 0
//        for (value in map.values) {
//            sum += value.second
//        }
        return sum
    }

    override fun runProblem() = connectionCost(mainTestcase, mainTestcase.size)
    override val mainTestcase get() = testCases[0]
    override val testCases = arrayOf(
        arrayOf(
            charArrayOf('A', 'B', '1'),
            charArrayOf('B', 'C', '4'),
            charArrayOf('B', 'D', '6'),
            charArrayOf('D', 'E', '5'),
            charArrayOf('C', 'E', '1')
        )
    )
}