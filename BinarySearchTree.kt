object BinarySearchTree : Problem.Medium(700) {
    override fun runProblem() = searchBST()

    private fun searchBST(root: TreeNode? = testCases[0], `val`: Int = 4): TreeNode? {
        if (root == null || root.`val` == `val`) return root
        return searchBST(root.left, `val`) ?: searchBST(root.right, `val`)
    }

    private fun searchBSTIteratively(root: TreeNode? = testCases[0], `val`: Int = 4) = root?.bstSearch(`val`)

    override val testCases = arrayOf(
        buildTreeFromArray(32, 26, 47, 19, null, null, 56, null, 27),
        buildTreeFromArray(3, 1, 5, 0, 2, 4, 6),
        buildTreeFromArray(120, 70, 140, 50, 100, 130, 160, 20, 55, 75, 110, 119, 135, 150, 200)
    )
}