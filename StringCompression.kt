object StringCompression : Problem.Medium(443) {
    private fun compress(chars: CharArray = testCases[3]): Int {
        var total = 0
        var i = 0
        while (i < chars.size) {
            total++
            if (i == chars.size - 1 || chars[i + 1] != chars[i]) {
                i++
                continue
            }
            var counter = 0
            while (i + counter < chars.size && chars[i + counter] == chars[i]) counter++
            for (c in counter.toString()) chars[total++] = c
            i += counter
        }
        return total
    }

    private fun compressAndWrite(chars: CharArray): Int {
        var total = 0
        var i = 0
        while (i < chars.size) {
            val current = chars[i]
            chars[total++] = current
            val oldI = i
            while (i < chars.size && chars[i] == current) i++
            if ((i - oldI) == 1) continue
            for (c in (i - oldI).toString()) chars[total++] = c
        }
        return total
    }

    override val testCases = arrayOf(
            charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'),
            charArrayOf('a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c'),
            charArrayOf('a', 'a', 'a', 'b', 'b', 'a', 'a'),
            charArrayOf('a'),
            charArrayOf('a', 'b', 'c', 'c')
    )

    override fun runProblem() = compressAndWrite(testCases[3])

    override fun runTestCases() = testCases.map { compressAndWrite(it) }.forEach { println(it) }
}