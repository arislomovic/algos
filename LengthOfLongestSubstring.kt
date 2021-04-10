object LengthOfLongestSubstring : Problem.Easy(3) {
    override fun runProblem() = lengthOfLongestSubstring()
    private fun lengthOfLongestSubstring(s: String = "abcabcbb"): Int {
        if (s.isBlank()) return 0
        val arr = BooleanArray(26)
        var firstIndex = 0
        var secondIndex = 0
        var max = 0
        while (firstIndex < s.length) {
            val char = s[firstIndex] - 'a'
            if (arr[char]) {
                max = maxOf(firstIndex - secondIndex, max)
                while (arr[char]) {
                    arr[secondIndex++] = false
                }
            }
            arr[firstIndex++] = true
        }
        return max
    }

    override fun runTestCases() = testCases.map { lengthOfLongestSubstring(it) }.getString().print()
    override val testCases = arrayOf("abcabcbb", "bbbbb", "pwwkew", "")
}