object KnightMoves : Problem.Medium(1197) {
    private fun minKnightMoves(x: Int, y: Int): Int {
        val dx = intArrayOf(1, 2, 2, -1, 1, -2, -2, -1)
        val dy = intArrayOf(2, 1, -1, -2, -2, -1, 1, 2)
        val seen = HashSet<Pair<Int, Int>>()
        val q = ArrayDeque<Pair<Int, Int>>()
        fun add(pair: Pair<Int, Int>) = if (seen.add(pair)) q.addLast(pair) else Unit
        add(0 to 0)
        var steps = 0
        while (q.isNotEmpty()) {
            val size = q.size
            repeat(size) {
                val cell = q.removeFirst().also { if (it == x to y) return steps }
                for (k in 0..7) {
                    val next = cell.first + dx[k] to cell.second + dy[k]
                    if (next.first in -300..300 && next.second in -300..300) add(next)
                }
            }
            steps++
        }
        return -1
    }

    override fun runProblem() = minKnightMoves(2, 4)
}