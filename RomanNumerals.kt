import RobotBounded.isRobotBounded

object RomanNumerals : Problem.Easy(13) {
    fun romanToInt(s: String): Int {
        var sum = 0
        var counter = 0
        while (counter < s.length) {
            val current = findValue(s[counter++])
            if (counter >= s.length) {
                sum += current
                continue
            }
            val next = findValue(s[counter])
            sum += if (current < next) {
                counter++
                next - current
            } else {
                current
            }
        }
        return sum
    }

    fun findValue(c: Char) = when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }

    override val testCases get() = arrayOf("III", "IV", "IX", "LVIII", "MCMXCIV")
    override val mainTestcase get() = testCases[2]
    override fun runProblem() = isRobotBounded(mainTestcase)

}