object BinaryTreeTraversal : Problem.Easy(94) {
    override fun runProblem() = testCases[0]
        .run { preorderTraversal(this) + "\n" + inOrderTraversal(this) + "\n" + postOrderTraversal(this) }

    override val testCases = BinarySearchTree.testCases
    private fun preorderTraversal(root: TreeNode?): List<Int> {
        root ?: return listOf()
        val list = ArrayList<Int>()
        val stack: ArrayDeque<TreeNode> = arrayDequeOf(root)
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            list.add(current.`val`)
            current.addToQueue(stack)
        }
        return list
    }

    private fun inOrderTraversal(root: TreeNode?): List<Int> {
        root ?: return listOf()
        val list = ArrayList<Int>()
        val stack: ArrayDeque<TreeNode> = arrayDequeOf(root)
        var current = root
        while (stack.isNotEmpty() || current != null) {
            while (current != null) {
                stack.addFirst(current)
                current = current.left
            }
            current = stack.removeLast()
            list.add(current.`val`)
            current = current.right
        }
        return list
    }

    private fun postOrderTraversal(root: TreeNode?): List<Int> {
        var current: TreeNode? = root ?: return emptyList()
        val list = ArrayList<Int>()
        val stack: ArrayDeque<TreeNode> = ArrayDeque()
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                if (current.right != null) stack.addFirst(current.right!!)
                stack.addFirst(current)
                current = current.left
            }
            current = stack.removeLast()
            current = if (stack.lastOrNull() == current.right) {
                stack.removeLast()
                stack.addFirst(current)
                current.right
            } else {
                list.add(current.`val`)
                null
            }
        }
        return list
    }
}