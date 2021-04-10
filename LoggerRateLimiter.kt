object LoggerRateLimiter : Problem.Easy(359) {
    private class Logger : HashMap<String, Int>() {
        fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
            val m = this.getOrDefault(message, -1)
            if (m != -1 && timestamp - m < 10) return false
            this[message] = timestamp
            return true
        }

    }

    override fun runProblem() = Logger().run {
        buildString {
            appendLine(shouldPrintMessage(1, "foo"))
            appendLine(shouldPrintMessage(2, "bar"))
            appendLine(shouldPrintMessage(3, "foo"))
            appendLine(shouldPrintMessage(8, "bar"))
            appendLine(shouldPrintMessage(10, "foo"))
            appendLine(shouldPrintMessage(11, "foo"))
        }

    }
}