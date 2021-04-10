object BullsAndCows : Problem.Medium(299) {
    private fun getHint(secret: String, guess: String): String {
        val map = IntArray(10)
        var newGuess = ""
        for (i in secret.indices) {
            if (guess[i] == secret[i]) continue
            newGuess += guess[i]
            map[secret[i] - '0']++
        }
        val cows = newGuess.count { map[it - '0']-- > 0 }

        return "${guess.length - newGuess.length}A${cows}B"
    }

    fun getHintSpace(secret: String, guess: String): String? {
        val map = IntArray(10)
        var bulls = 0
        var cows = 0
        for (i in guess.indices) {
            if (secret[i] == guess[i]) bulls++
            else if (map[secret[i] - '0']++ < 0 || map[guess[i] - '0']-- > 0) cows++
        }
        return "${bulls}A${cows}B"
    }


    override fun runProblem() = getHint(mainTestcase.first, mainTestcase.second)
    override val mainTestcase get() = testCases[3]

    override
    val testCases = arrayOf("1807" to "7810", "1123" to "0111", "1" to "0", "1" to "1")
}