object MaximumAverageSubtree : Problem.Medium(1120) {
    //Given the root of a binary tree, find the maximum average value of any subtree of that tree.
    //(A subtree of a tree is any node of that tree plus all its descendants.
    // The average value of a tree is the sum of its values, divided by the number of nodes.)

    //Imagine that an employment tree represents the formal employee hierarchy at Amazon. Manager nodes have
    //child nodes for each employee that reports to them; each of these employees can, in turn, have child nodes
    //representing their respective reportees. Each node in the tree contains an integer representing the number of
    //months the employee has spent at the company. Team tenure is computed as the average tenure of the manager
    //and all the company employees working below the manager. The oldest team has the highest team tenure.
    //
    //Write an algorithm to find the manager of the team with the highest tenure. An employee must have child nodes
    //to be a manager.
    private lateinit var max: Pair<TreeNode, Double>

    private fun maximumAverageSubtree(root: TreeNode?): Double {
        max = (root ?: return 0.0) to root.`val`.toDouble()
        maximumAverageSubtreeInternal(root)
        return max.second
    }

    private fun maximumAverageSubtreeInternal(root: TreeNode?): Pair<Int, Int> {
        root ?: return 0 to 0
        val left = maximumAverageSubtreeInternal(root.left)
        val right = maximumAverageSubtreeInternal(root.right)
        val total = left.first + right.first + root.`val`
        val children = left.second + right.second + 1
        val average = total.toDouble() / children.toDouble()
        if (max.second < average) max = root to average
        return total to children
    }

    override fun runProblem() = maximumAverageSubtree(mainTestcase)
    override val mainTestcase get() = testCases[0]
    override val testCases = arrayOf(
        buildTreeFromArray(5, 6, 1),
        buildTreeFromArray(1),
        buildTreeFromArray(),
    )
}