object ValidateBinarySearchTree : Problem.Medium(98) {

    private fun isValidBSTRecursiveInOrder(root: TreeNode?, prev: Int? = null): Boolean {
        root ?: return true
        if (!isValidBSTRecursiveInOrder(root.left, prev)) return false
        prev?.run { if (this >= root.`val`) return false }
        return isValidBSTRecursiveInOrder(root.right, root.`val`)
    }

    fun isValidBSTIterativeInOrder(root: TreeNode?): Boolean {
        var current: TreeNode? = root ?: return true
        val stack = ArrayDeque<TreeNode>()
        var prev: Int? = null
        while (stack.isNotEmpty() || current != null) {
            while (current != null) {
                stack.addFirst(current)
                current = current.left
            }
            current = stack.removeLast()
            if (prev != null && prev >= current.`val`) return false
            prev = current.`val`
            current = current.right
        }
        return true
    }

    private fun isValidBSTIteratively(root: TreeNode?): Boolean {
        val nodes: ArrayDeque<TreeNode?> = arrayDequeOf(root ?: return true)
        val highs: ArrayDeque<Int?> = arrayDequeOf(null)
        val lows: ArrayDeque<Int?> = arrayDequeOf(null)
        fun addToStacks(node: TreeNode?, high: Int?, low: Int?) {
            nodes.addLast(node)
            lows.addLast(low)
            highs.addLast(high)
        }
        while (nodes.isNotEmpty()) {
            val current = nodes.removeFirst() ?: continue
            val low = lows.removeFirst()
            val high = highs.removeFirst()
            if (low != null && low >= current.`val`) return false
            if (high != null && high <= current.`val`) return false
            addToStacks(current.right, high, current.`val`)
            addToStacks(current.left, current.`val`, low)
        }
        return true
    }

    private fun isValidBST(root: TreeNode?, upper: Int? = null, lower: Int? = null): Boolean =
            if (root == null) true
            else if (upper != null && root.`val` >= upper || lower != null && root.`val` <= lower) false
            else isValidBST(root.left, root.`val`, lower) && isValidBST(root.right, upper, root.`val`)

    override fun runProblem() = isValidBST(buildTreeFromArray(1, 2, 6, 3, 5, 1))
}