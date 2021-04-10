object CloneGraph : Problem.Easy() {

    override fun runProblem() = cloneGraph(Node(3, neighbors = arrayListOf(Node(2))))?.toString().orEmpty()
    private val map = HashMap<Int, Node>()

    private fun cloneGraph(node: Node?): Node? {
        node ?: return null
        if (map.containsKey(node.`val`)) return map[node.`val`]
        val newNode = Node(node.`val`)
        map[node.`val`] = newNode
        for (it in node.neighbors) newNode.neighbors.add(cloneGraph(it))
        return newNode
    }
}