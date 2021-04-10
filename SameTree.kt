object SameTree : Problem.Easy() {
    override fun runProblem() = isSameTree()
    fun isSameTree(p: TreeNode? = TreeNode(1), q: TreeNode? = TreeNode(0)): Boolean {
        val stackP = arrayDequeOf(p ?: return q == null)
        val stackQ = arrayDequeOf(q ?: return false)
        while (stackP.isNotEmpty()) {
            val currentP = stackP.removeFirst()
            val currentQ = stackQ.removeFirst()
            if (currentP.`val` != currentQ.`val` ||
                currentP.left?.`val` != currentQ.left?.`val` ||
                currentQ.right?.`val` != currentP.right?.`val`
            ) {
                return false
            }
            currentQ.left?.let { stackQ.addFirst(it) }
            currentP.left?.let { stackP.addFirst(it) }
            currentP.right?.let { stackP.addFirst(it) }
            currentQ.right?.let { stackQ.addFirst(it) }
        }
        return true
    }
}