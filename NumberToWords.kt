import java.lang.StringBuilder

object NumberToWords : Problem.Hard(273) {

    override fun runProblem() = numberToWords(1000000)

    private fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"
        var commas = 0
        var s = ""
        var mNum = num
        while (mNum > 0) {
            val currentS = getStringFromThousand(mNum)
            if (currentS.isNotBlank()) s = currentS + zeros[commas++] + s
            else commas++
            mNum /= 1000
        }
        return s.removeSuffix(" ")
    }

    private val zeros = arrayOf("", "Thousand ", "Million ", "Billion ", "Trillion")

    private fun getStringFromThousand(num: Int): String {
        var mNum = num % 1000
        val builder = StringBuilder()
        if (mNum > 99) builder.append(oneMap[mNum / 100]).append("Hundred ")
        mNum %= 100
        if (mNum < 20) return builder.append(oneMap[mNum]).toString()
        builder.append(tenMap[mNum / 10])
        mNum %= 10
        return builder.append(oneMap[mNum]).toString()
    }

    private val oneMap = arrayOf(
        "",
        "One ",
        "Two ",
        "Three ",
        "Four ",
        "Five ",
        "Six ",
        "Seven ",
        "Eight ",
        "Nine ",
        "Ten ",
        "Eleven ",
        "Twelve ",
        "Thirteen ",
        "Fourteen ",
        "Fifteen ",
        "Sixteen ",
        "Seventeen ",
        "Eighteen ",
        "Nineteen "
    )

    private val tenMap = arrayOf(
        "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "
    )
}