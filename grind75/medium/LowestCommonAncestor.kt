package grind75.medium

import Problem
import TreeNode
import buildTreeFromArray
import print

object LowestCommonAncestor : Problem.Medium(236) {
    private fun lowestCommonAncestor(root: TreeNode?, p: Int, q: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == p || root.`val` == q) return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        return when {
            left != null && right != null -> root
            left != null -> left
            else -> right
        }
    }

    override fun runProblem() =
        lowestCommonAncestor(mainTestcase.first, mainTestcase.second, mainTestcase.third)?.`val`?.print()

    override val mainTestcase get() = testCases[1]

    override val testCases = arrayOf(
        buildTreeFromArray(3, 5, 1, 6, 2, 0, 8, null, null, 5, 4).run { Triple(this, 5, 4) },
        buildTreeFromArray(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4).run { Triple(this, 1, 3) },
        buildTreeFromArray(1, 2).run { Triple(this, 1, 2) }
    )
}