object PathSum : Problem.Easy(112) {

    private fun hasPathSum(root: TreeNode?, sum: Int): Boolean = when {
        root == null || root.`val` > sum || root.left ?: root.right == null -> false
        root.`val` == sum -> true
        else -> hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
    }

    private fun addNode(node: TreeNode?, prevSum: Int, q: ArrayDeque<Pair<TreeNode, Int>>, targetSum: Int): Boolean {
        val next = node?.`val`?.plus(prevSum) ?: return false
        return when {
            next > targetSum -> false
            next == targetSum -> true
            else -> {
                q.addFirst(node to next)
                false
            }
        }
    }

    private fun hasPathSumIteratively(root: TreeNode?, target: Int): Boolean {
        val q = ArrayDeque<Pair<TreeNode, Int>>()
        fun addNode(node: TreeNode?, prevSum: Int) = addNode(node, prevSum, q, target)
        if (addNode(root ?: return false, 0)) return true
        while (q.isNotEmpty()) {
            q.removeLast().run { if (addNode(first.left, second) || addNode(first.right, second)) return true }
        }
        return false
    }

    override val mainTestcase get() = testCases[0]
    override fun runTestCases() = testCases.map { hasPathSumIteratively(it.first, it.second) }.print()
    override fun runProblem() = hasPathSum(mainTestcase.first, mainTestcase.second)
    override val testCases = arrayOf(
        buildTreeFromArray(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1) to 22,
        buildTreeFromArray(1, 2, 3) to 5,
        buildTreeFromArray(1, 2) to 0,
    )
}