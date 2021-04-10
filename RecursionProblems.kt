object RecursionProblems : Problem.Easy() {
    private fun maxDepth(root: TreeNode?) = maxDepth(root, 0)
    private fun isSymmetricRecursive(root: TreeNode?) = isSymmetric(root, root)

    private fun isSymmetricLinear(root: TreeNode?): Boolean {
        val stack: ArrayDeque<Pair<TreeNode?, TreeNode?>> = arrayDequeOf((root ?: return true) to root)
        while (stack.isNotEmpty()) {
            val current = stack.last().first
            val compared = stack.removeLast().second
            if (current?.`val` != compared?.`val`) return false
            if (current == null || compared == null) continue
            stack.addFirst(current.left to compared.right)
            stack.addFirst(current.right to compared.left)
        }
        return true
    }

    private fun maxDepth(root: TreeNode?, i: Int): Int = root?.run {
        maxOf(maxDepth(left, i + 1), maxDepth(right, i + 1))
    } ?: 0

    private fun isSymmetric(root: TreeNode?, compared: TreeNode?): Boolean =
        if (root == null || compared == null) compared == root
        else root.`val` == compared.`val`
                && isSymmetric(root.left, compared.right)
                && isSymmetric(root.right, compared.left)

    var count = 0
    private fun isUniVal(node: TreeNode?, `val`: Int): Boolean {
        node ?: return true
        if (!isUniVal(node.left, node.`val`) or !isUniVal(node.right, node.`val`)) return false
        count++
        return node.`val` == `val`
    }

    private fun countUnivalSubtrees(root: TreeNode?): Int {
        isUniVal(root, 0)
        return count
    }

}
