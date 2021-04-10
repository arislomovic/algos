object LongestCommonPrefix : Problem.Easy(14) {
    private fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size < 2) return strs.firstOrNull().orEmpty()
        var index = 0
        while (true) {
            for (i in strs) {
                if (index >= i.length || i[index] != strs[0][index]) return strs[0].substring(0, index)
            }
            index++
        }
    }

    override fun runProblem() = longestCommonPrefix(testCases[0])

    override val testCases = arrayOf(
        arrayOf("dog", "racecar", "car"),
        arrayOf("flower", "flow", "flight"),
        arrayOf("flower", "flowered", "flowering"),
        arrayOf("", "flowered", "flowering"),
        arrayOf("f", "", "flowering"),
        arrayOf(),
    )

    override fun runTestCases() = testCases.forEach { println(longestCommonPrefix(it)) }
}