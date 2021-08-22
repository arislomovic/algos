object LinkedListCycle : Problem.Easy(141) {
    fun hasCycle(head: ListNode?): Boolean {
        val set = HashSet<ListNode>()
        var cur: ListNode? = head ?: return false
        while (cur != null) {
            if (set.add(cur).not()) {
                return true
            }
            cur = cur.next
        }
        return false
    }
    fun hasCycleRunnerWalker(head: ListNode?): Boolean {
        var walker = head
        var runner = head
        while (runner?.next != null) {
            walker = walker?.next
            runner = runner.next?.next
            if (walker == runner) return true
        }
        return false
    }
}