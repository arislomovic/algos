object WordBreak : Problem.Medium(139) {
    private fun wordBreak(s: String, wordDict: List<String>) = wordBreak(s, wordDict.toHashSet())

    private fun wordBreak(s: String, wordDict: HashSet<String>): Boolean {
        if (wordDict.contains(s)) return true
        repeat(s.length) {
            val a = s.substring(0, it)
            if (wordDict.contains(a)) {
                if (wordBreak(s.substring(it), wordDict)) return true
            }
        }
        return false
    }
    private fun wordBreakMemo(s: String, wordDict: Set<String>, start: Int, memo: Array<Boolean?>): Boolean {
        if (start == s.length) {
            return true
        }
        if (memo[start] != null) {
            return memo[start]!!
        }
        for (end in start + 1..s.length) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return true.also { memo[start] = it }
            }
        }
        return false.also { memo[start] = it }
    }
    fun wordBreakDP(s: String, wordDict: List<String>?): Boolean {
        val wordDictSet: Set<String> = HashSet(wordDict)
        val dp = BooleanArray(s.length + 1) .apply{ this[0]  = true}
        for (i in 1..s.length) {
            for (j in 0 until i) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }

    override fun runTestCases() = testCases.map { wordBreak(it.second, it.first) }
    override fun runProblem() = wordBreak(mainTestcase.second, mainTestcase.first)
    override val mainTestcase get() = testCases[2]
    override val testCases = arrayOf(
        listOf("leet", "code") to "leetcode",
        listOf("apple", "pen") to "applepenapple",
        listOf("cats", "dog", "sand", "and", "cat") to "catsandog",
    )


}