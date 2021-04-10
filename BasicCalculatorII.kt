object BasicCalculatorII : Problem.Medium(227) {
    override fun runTestCases() = testCases.map { calculate(it).toString() }

    private fun calculate(s: String): Int {
        if (s.isEmpty()) return 0
        var currentSum = 0
        var lastNumber = 0
        var result = 0
        //For first bunch of numbers, we know we must add these to the total, so we keep it as +
        var previousOperation = '+'
        for (i in s.indices) {
            val currentChar = s[i]
            //Keeps adding the numbers until an operator is found or end is reached
            if (currentChar.isDigit()) currentSum = currentSum * 10 + (currentChar - '0')
            //Processing numbers we just passed
            if ((currentChar.isDigit() || currentChar.isWhitespace()) && i != s.length - 1) continue
            lastNumber = when (previousOperation) {
                //LAST NUMBER KEEPS GETTING STORED UNTIL A +/- is found.
                '*' -> lastNumber * currentSum
                '/' -> lastNumber / currentSum
                '+', '-' -> {
                    result += lastNumber
                    if (previousOperation == '+') currentSum else -currentSum
                }
                else -> lastNumber
            }
            previousOperation = currentChar
            currentSum = 0
        }
        return result + lastNumber
    }

    override fun runProblem() = calculate(testCases[8])
    override val testCases = arrayOf(
        "2*3+4",
        " 3/2 ",
        " 3+5 / 2 ",
        "5*2",
        "3+2*2",
        "1+1+1",
        "1*1-2",
        "1-1-1",
        "14/3-2",
        "1",
        "1+11/2*11-1",
        "0+0"
    )
}