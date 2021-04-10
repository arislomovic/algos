object DecodeWays : Problem.Medium(91) {
    override fun runProblem() = numDecodings("2")
    private fun numDecodings(s: String): Int {
        if (s.startsWith("0")) return 0
        val stack = arrayDequeOf(0)
        var count = 0
        val length = s.length
        while (stack.isNotEmpty()) {
            val last = stack.removeLast()
            if (last < length && s[last] == '0') continue
            if (last >= length - 1) {
                count++
                continue
            }
            if (doubleDigit(s, last)) stack.add(last + 2)
            stack.add(last + 1)
        }
        return count
    }

    private fun numDecodings(s: String, index: Int, length: Int = s.length): Int {
        if (index < length && s[index] == '0') return 0
        if (length - 1 <= index) return 1
        return numDecodings(s, index + 1) + if (doubleDigit(s, index)) numDecodings(s, index + 2) else 0
    }

    fun doubleDigit(s:String, index: Int) = s[index].toDigit() * 10 + s[index + 1].toDigit() <= 26

    override val testCases = arrayOf("12", "226", "0", "01", "103", "120")

    override fun runTestCases() = testCases.map { numDecodings(it) }.toString()

}