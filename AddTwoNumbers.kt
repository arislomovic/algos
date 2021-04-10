object AddTwoNumbers : Problem.Medium(2) {
    override fun runProblem() = addTwoNumbers(mainTestcase.first, mainTestcase.second)?.collect()?.toString().orEmpty()

    private fun addTwoNumbers(l1: ListNode? = testCases[4].first, l2: ListNode? = testCases[4].second): ListNode? {
        var previousSum = 0
        var currentL1 = l1
        var currentL2 = l2
        var finalNode: ListNode? = null
        var nextNode: ListNode? = null
        while (currentL1 != null || currentL2 != null) {
            val sum = (currentL1?.`val` ?: 0) + (currentL2?.`val` ?: 0) + previousSum
            val current = ListNode(sum % 10)
            previousSum = sum/10
            if (finalNode == null) finalNode = current
            else nextNode?.next = current
            nextNode = current
            currentL1 = currentL1?.next
            currentL2 = currentL2?.next
        }
        if (previousSum != 0) nextNode?.next = ListNode(previousSum)
        return finalNode
    }

    override val mainTestcase get() = testCases[0]
    override fun runTestCases() =
        testCases.map { addTwoNumbers(it.first, it.second) }.map { it?.collect().orEmpty().getString() }.print()

    override val testCases =
        arrayOf(
            buildListNodes(2, 4, 3) to buildListNodes(5, 6, 4),
            buildListNodes(0) to buildListNodes(0),
            buildListNodes(9, 9, 9, 9) to buildListNodes(9, 9, 9, 9, 9, 9, 9),
            buildListNodes(9) to buildListNodes(1, 9, 9, 9, 9, 9, 9, 9, 9, 9),
            buildListNodes(
                1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1
            ) to buildListNodes(5, 6, 4)
        )
}