package fb

object RotationalCipher : Problem.Misc() {

    private fun rotationalCipher(input: String, rotationFactor: Int): String {
        // Write your code here
        val arr = input.toCharArray()
        for (index in arr.indices) {
            var c = arr[index]
            if (!c.isLetterOrDigit()) continue
            for (i in 0 until rotationFactor) {
                when (c) {
                    'z' -> c = 'a' - 1
                    'Z' -> c = 'A' - 1
                    '9' -> c = '0' - 1
                }
                c++
            }
            arr[index] = c
        }
        return String(arr)
    }

    override fun runProblem() = rotationalCipher(mainTestcase.first, mainTestcase.second)
    override fun runTestCases() = testCases.map { rotationalCipher(it.first, it.second) == it.third}
    override val mainTestcase = testCases[0]
    override val testCases
        get() = arrayOf(
            Triple("Zebra-493?", 3, "Cheud-726?"),
            Triple("All-convoYs-9-be:Alert1.", 4, "Epp-gsrzsCw-3-fi:Epivx5."),
            Triple("abcdZXYzxy-999.@", 200, "stuvRPQrpq-999.@")
        )
}