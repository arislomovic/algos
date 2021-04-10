object DecodeString : Problem.Medium(394) {

    override val testCases = arrayOf("3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz")
    override val mainTestcase = testCases[0]
    override fun runProblem() = decodeString(mainTestcase)
    private fun decodeString(s: String): String {
        if (s.isBlank()) return s
        val queue = ArrayDeque<Char>()
        for (char in s) {
            queue.add(char)
            if (queue.last() != ']') continue
            queue.removeLast()
            var charsToRepeat = ""
            var number = ""
            while (queue.last() != '[') {
                charsToRepeat = queue.removeLast() + charsToRepeat
            }
            queue.removeLast()
            while (queue.isNotEmpty() && queue.last().isDigit()) {
                number = queue.removeLast() + number
            }
            repeat(number.toInt()) {
                for (repeated in charsToRepeat) queue.add(repeated)
            }
        }
        return CharArray(queue.size) { queue.removeFirst() }.run { String(this) }
    }
}