package grind75.easy

import Problem
import TreeNode
import kotlin.math.abs

object BalancedBinaryTree : Problem.Easy(110) {
    private var result = true
    fun isBalanced(root: TreeNode?): Boolean {
        maxDepth(root)
        return result
    }
    private fun maxDepth(root: TreeNode?): Int {
        if (root == null || !result) return 0
        val l = maxDepth(root.left)
        val r = maxDepth(root.right)
        if (abs(l - r) > 1) result = false
        return 1 + maxOf(l, r)
    }
}