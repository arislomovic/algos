object ReverseLinkedList : Problem.Easy(206) {
    private fun reverseListBuild(head: ListNode?): ListNode? {
        var reversed: ListNode? = null
        var current = head
        while (current != null) {
            reversed = ListNode(current.`val`, reversed)
            current = current.next
        }
        return reversed
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }

    private fun reverseListRecursive(head: ListNode?): ListNode? {
        val p: ListNode? = reverseListRecursive(head?.next ?: return null)
        head.next!!.next = head
        head.next = null
        return p
    }

    override val testCases = MergeTwoLists.testCases
    override val mainTestcase = testCases[0]
    override fun runProblem() = reverseList(mainTestcase)
}