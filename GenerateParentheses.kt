object GenerateParentheses : Problem.Easy(22) {
    public override fun runProblem() = generateParenthesis(5).size
    private fun generateParenthesis(n: Int): List<String> {
        val stack = arrayDequeOf("()")
        for (i in 1 until n) {
            val size = stack.size
            repeat(size) {
                val current = stack.removeLast()
                stack.addFirst("($current)")
                val before = "()$current"
                val after = "$current()"
                stack.addFirst(after)
                if (before != after) stack.addFirst(before)
            }
        }
        return stack
    }
}