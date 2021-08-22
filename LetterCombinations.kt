object LetterCombinations :  Problem.Medium(17) {
    override fun runProblem() = letterCombinations("23")
    private fun letterCombinations(digits: String) = letterCombinationRecursively(digits, "", arrayListOf(), 0)

    private fun letterCombinationRecursively(digits: String, current: String, all: ArrayList<String>, index: Int)
            : ArrayList<String> {
        if (current.length == digits.length) return all.apply { add(current) }
        for (i in getLettersFromDigits(digits[index])) {
            letterCombinationRecursively(digits, current + i, all, index + 1)
        }
        return all
    }

    private fun getLettersFromDigits(n: Char) = when (n) {
        '2' -> charArrayOf('a', 'b', 'c')
        '3' -> charArrayOf('d', 'e', 'f')
        '4' -> charArrayOf('g', 'h', 'i')
        '5' -> charArrayOf('j', 'k', 'l')
        '6' -> charArrayOf('m', 'n', 'o')
        '7' -> charArrayOf('p', 'q', 'r', 's')
        '8' -> charArrayOf('t', 'u', 'v')
        '9' -> charArrayOf('q', 'x', 'y', 'z')
        else -> charArrayOf()
    }
}