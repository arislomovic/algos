object LongestStringChain : Problem.Medium(1048) {
    private fun longestStrChain(words: Array<String>): Int {

        if (words.isEmpty()) return 0

        words.sortBy { it.length }

        val dp = IntArray(words.size) { 1 }

        var count = 0

        for (hi in 1 until words.size) {
            repeat(hi) { lo ->
                if (isPredecessor(words[lo], words[hi])) {
                    dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                }
            }

            count = maxOf(count, dp[hi])
        }

        return count
    }

    private fun isPredecessor(s1: String, s2: String): Boolean {
        if (s1.length != s2.length - 1) return false
        var s1Counter = 0
        var s2Counter = 0
        while (s2Counter < s2.length) {
            if (s1Counter < s1.length && s1[s1Counter] == s2[s2Counter]) s1Counter++
            else if (s2Counter - s1Counter == 1) return false
            s2Counter++
        }
        return true
    }

    override fun runProblem() = longestStrChain(testCases[2])
    override val testCases = arrayOf(
        arrayOf(
            "a", "b", "ba", "bca", "bda", "bdca"
        ),
        arrayOf(
            "xbc", "pcxbcf", "xb", "cxbc", "pcxbc"
        ),
        arrayOf(
            "bdca", "bda", "ca", "dca", "a"
        )
    )
}