open class BaseNode(val `val`: Int) {
    open fun collect(): List<Int> = listOf()
    override fun toString() = collect().toString()
}

class Node(v: Int, var neighbors: ArrayList<Node?> = ArrayList()) : BaseNode(v) {
    constructor(id: Int, vararg neighbors: Node) : this(v = id, neighbors = arrayListOf(*neighbors))

    override fun collect(): List<Int> = listOf(`val`) + neighbors.filterNotNull().map { it.collect() }.flatten()
}

open class BaseListNode<T : BaseListNode<T>>(`val`: Int, open var next: T? = null) : BaseNode(`val`)

class ListNode(v: Int, next: ListNode? = null) : BaseListNode<ListNode>(v, next) {
    fun clone(): ListNode = ListNode(`val`, next?.clone())
    override fun collect(): List<Int> = listOf(`val`) + next?.collect().orEmpty()
}

class RandomNode(v: Int, next: RandomNode? = null, var random: RandomNode?) : BaseListNode<RandomNode>(v, next)

class TreeNode(v: Int, var left: TreeNode? = null, var right: TreeNode? = null) : BaseNode(v) {
    override fun collect(): List<Int> = left?.collect().orEmpty() + listOf(`val`) + right?.collect().orEmpty()
    fun bstSearch(key: Int): TreeNode? {
        val stack = arrayDequeOf(this)
        while (stack.isNotEmpty()) {
            stack.removeLast().let { if (it.`val` == key) return it else it.addToQueue(stack) }
        }
        return null
    }

    fun addToQueue(q: ArrayDeque<TreeNode>) {
        left?.run { q.addFirst(this) }
        right?.run { q.addFirst(this) }
    }
}

class Robot(private val arr: Array<IntArray>, private var position: Pair<Int, Int>) {
    private var movement = 0 to -1
    override fun toString() = arr.getArrayString()
    fun turnLeft() = apply { movement = movement.second to -movement.first }
    fun turnRight() = apply { movement = -movement.second to movement.first }
    fun clean() = run { arr[position.first][position.second] = 2 }
    fun move(): Boolean {
        val x = position.first + movement.first
        val y = position.second + movement.second
        if (!arr.isSafe(x, y, 0)) return false
        position = x to y
        return true
    }
}

class Master(private val secret: String, val words: Array<String>, private var guesses: Int = 10) {
    constructor(words: Array<String>, secret: Int = 0, guesses: Int = 10) : this(words[secret], words, guesses)

    fun guess(s: String): Int {
        if (guesses-- <= 0) throw Exception("Either you took too many guesses, or you did not find the secret word.")
        if (!words.contains(s)) return -1
        return s.countIndexed { item, index -> item == secret[index] }
    }
}

open class VersionControl {
    fun isBadVersion(version: Int): Boolean = false
}



