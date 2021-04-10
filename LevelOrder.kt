object LevelOrder : Problem.Easy() {
    override fun runProblem() = buildString {
        levelOrder(testCases[0]).let { i -> i.forEach { append(it.getString()) } }
    }

    private fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue: ArrayDeque<TreeNode> = arrayDequeOf(root?: return listOf())
        val list: ArrayList<List<Int>> = arrayListOf(listOf(root.`val`))
        fun TreeNode.addToQueueAndStack(nextList: ArrayList<Int>) {
            queue.addLast(this)
            nextList.add(`val`)
        }
        while (queue.isNotEmpty()) {
            val size = queue.size
            val nextList = ArrayList<Int>(size)
            repeat(size) {
                val next = queue.removeLast()
                next.left?.addToQueueAndStack(nextList)
                next.right?.addToQueueAndStack(nextList)
            }
            if (nextList.isNotEmpty()) list.add(nextList)
        }
        return list
    }

    override val testCases = BinarySearchTree.testCases
}