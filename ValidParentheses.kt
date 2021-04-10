//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
object ValidParentheses : Problem.Easy(20) {

    private fun isValid(s: String): Boolean {
        val stack: ArrayDeque<Char> = ArrayDeque()
        for (char in s) {
            if (stack.lastOrNull() == findComplement(char)) stack.removeLast()
            else stack.addFirst(char)
        }
        return stack.isEmpty()
    }

    private fun findComplement(x: Char) = when (x) {
        '[' -> ']'
        '{' -> '}'
        '(' -> ')'
        else -> ' '
    }

    override fun runProblem() = isValid("[{}]")
}