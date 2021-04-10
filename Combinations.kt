object Combinations : Problem.Medium(77) {
    override fun runProblem() = combine(4, 1, 1, ArrayDeque(), arrayListOf())
    private fun combine(n: Int, k: Int, cur: Int = 1, q: ArrayDeque<Int>, all: ArrayList<List<Int>>): List<List<Int>> {
        if (q.size == k) return all.apply { add(ArrayList(q)) }
        if (cur > n) return all
        combine(n, k, cur + 1, q.apply { add(cur) }, all)
        return combine(n, k, cur + 1, q.apply { removeLast() }, all)
    }

    private fun combineIteratively(n: Int, k: Int): List<List<Int>> {
        val list = ArrayDeque<Int>()
        val all = ArrayList<List<Int>>()
        var current = 0
        while (++current <= n) {
            list.add(current)
            if (list.size == k) {
                all.add(ArrayList(list))
                if (current != n) {
                    list.removeLast()
                    continue
                }
            }
            if (current != n) continue
            if (list.isEmpty()) break
            val next = list.first() + 1
            list.clear()
            list.add(next)
            current = next
        }
        return all
    }
}