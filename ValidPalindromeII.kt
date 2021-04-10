object ValidPalindromeII : Problem.Medium(680) {
    private fun validPalindrome(str: String): Boolean {
        var low = 0
        var high: Int = str.length - 1

        while (low < high) {
            if (str[low] != str[high]) return isPalindrome(str, low + 1, high) || isPalindrome(str, low, high - 1)
            low++
            high--
        }
        return true
    }

    private fun isPalindrome(str: String, low: Int, high: Int): Boolean {
        var mLow = low
        var mHigh = high
        while (low < high) {
            if (str[mLow++] != str[mHigh--]) return false
        }
        return true
    }

    override fun runProblem() = validPalindrome(testCases.last())

    override val testCases = arrayOf("aba", "abca", "acbsfrbca", "", "a", "absbvbbad",
            "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga")

    override fun runTestCases() = testCases.map { (it to validPalindrome(it)).toString() }
}