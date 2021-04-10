object MinParenthesesRemoval : Problem.Medium(1249) {
    private fun minRemoveToMakeValid(s: String): String {
        val deque = ArrayDeque<Int>()
        for (c in s.indices) {
            if (s[c] != ')' && s[c] != '(') continue
            if (s[c] == ')' && deque.isNotEmpty() && s[deque.last()] == '(') deque.removeLast()
            else deque.addLast(c)
        }
        if (deque.isEmpty()) return s
        if (deque.size == s.length) return ""
        var sCounter = 0
        val arr = CharArray(s.length - deque.size){
            while (deque.isNotEmpty() && sCounter == deque.first()) {
                deque.removeFirst()
                sCounter++
            }
            s[sCounter++]
        }
        return String(arr)
    }

    override fun runProblem() = minRemoveToMakeValid(mainTestcase)


    override val mainTestcase get() = testCases[3]
    override val testCases = arrayOf(
        "lee(t(c)o)de)",
        "a)b(c)d",
        "))((",
        "a(b(c)d)"
    )
}