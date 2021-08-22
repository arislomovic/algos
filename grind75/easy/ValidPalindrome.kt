package grind75.easy

object ValidPalindrome : Problem.Easy(125) {
    private fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1
        while (start < end) {
            val areSame = s[start].equals(s[end], ignoreCase = true)
            if (s[end].isLetter() && s[start].isLetter() && !areSame) return false
            if (!s[start].isLetter() || areSame) start++
            if (!s[end].isLetter() || areSame) end--
        }
        return true
    }

    override fun runProblem() = isPalindrome(testCases[0])
    override val testCases = arrayOf("A man, a plan, a canal: Panama", "race a car", "race car")
}