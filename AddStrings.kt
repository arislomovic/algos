
object AddStrings : Problem.Easy(415) {
    private fun addStrings(num1: String = "123", num2: String = "1888"): String {
        val length2 = num2.length - 1
        val length1 = num1.length - 1
        var counter = 0
        var remainder = 0
        var finalNum = ""
        while (counter <= length1 || counter <= length2) {
            val char1 = if (counter > length1) 0 else num1[length1 - counter] - '0'
            val char2 = if (counter > length2) 0 else num2[length2 - counter] - '0'
            var sum = char1 + char2 + remainder
            remainder = sum / 10
            sum %= 10
            finalNum = "$sum$finalNum"
            counter++
        }
        return finalNum
    }

    override fun runProblem() = addStrings()
    override val testCases = Array(5) { nextInt(0, 1000).toString() to nextInt(0, 1000).toString() }
    override fun runTestCases() = buildString {
        for (i in testCases) {
            appendLine(i)
            appendLine(addStrings(i.first, i.second))
            appendLine(i.first + i.second)
        }
    }
}