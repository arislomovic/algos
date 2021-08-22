import Problem.Companion.DIRECTIONS
import java.util.*
import kotlin.collections.ArrayDeque

fun <T> T.print() = apply { getStringAndPrint() }

fun <T> T.getStringAndPrint(): String = getString().apply { println(this) }
fun <T> T.getString() = when (this) {
    is ByteArray -> String(this)
    is IntArray -> toList().toString()
    is LongArray -> toList().toString()
    is DoubleArray -> toList().toString()
    is ShortArray -> toList().toString()
    is BooleanArray -> toList().toString()
    is FloatArray -> toList().toString()
    else -> toString()
}

fun isSafe(row: Int, rows: Int, col: Int, cols: Int) = row in 0 until rows && col in 0 until cols

fun <T> Iterable<T>.countOccurrences(map: AbstractMap<T, Int> = HashMap<T, Int>()) =
    map.also { for (i in this) it[i] = it.getOrDefault(i, 0) + 1 }


fun Char.toDigit(): Int = Character.getNumericValue(this)
fun <T> List<T>.getString(): String = let { buildString { it.forEach { i1 -> appendLine(i1) } } }

fun <T> arrayDequeOf(vararg t: T) = ArrayDeque(t.toList())

val Map<String, Int>.comparator
    get() =
        Comparator<String> { o1, o2 -> if (this[o1] != this[o2]) this[o1]!! - this[o2]!! else o1.compareTo(o2) }

fun <T, R> HashMap<T, R>.removeOrDefault(key: T, default: R): R = remove(key) ?: default
fun <T, R> HashMap<T, R>.operate(key: T, default: () -> R, operation: (R) -> R): R? {
    val value = getOrDefault(key, default.invoke()) ?: return null
    return operation.invoke(value).also { this[key] = it }
}


fun buildTreeFromArray(vararg arr: Int?): TreeNode? {
    fun buildTreeFromArray(vararg arr: Int?, root: TreeNode? = null, i: Int = 0): TreeNode? {
        if (i >= arr.size || arr[i] == null) return root
        val mRoot = TreeNode(arr[i]!!)
        mRoot.left = buildTreeFromArray(*arr, root = mRoot.left, i = 2 * i + 1)
        mRoot.right = buildTreeFromArray(*arr, root = mRoot.right, i = 2 * i + 2)
        return mRoot
    }
    return buildTreeFromArray(*arr, root = null, i = 0)
}

fun buildListNodes(vararg i: Int): ListNode {
    if (i.size < 2) return ListNode(i.getOrNull(0) ?: 0)
    val node = ListNode(i[0])
    var next = node
    for (a in 1 until i.size) {
        next.next = ListNode(i[a])
        next = next.next!!
    }
    return node
}

inline fun bfs(row: Int, col: Int, checkSafe: (row: Int, col: Int) -> Boolean): Int {
    var counter = 0
    val queue: ArrayDeque<Pair<Int, Int>> = arrayDequeOf(row to col)
    while (queue.isNotEmpty()) {
        val point = queue.removeFirst()
        counter++
        repeat(4) { moveIndex ->
            val nextX = point.first + DIRECTIONS[moveIndex]
            val nextY = point.second + DIRECTIONS[moveIndex + 1]
            if (checkSafe.invoke(nextX, nextY)) queue.addLast(nextX to nextY)
        }
    }
    return counter
}

fun CharArray.toIntArray() = IntArray(size) { if (this[it].isDigit()) this[it] - '0' else 0 }
fun CharArray.asString() = String(this)
fun CharArray.countIndexed(check: (item: Char, index: Int) -> Boolean): Int {
    var sum = 0
    for (i in indices) if (check.invoke(this[i], i)) sum++
    return sum
}

fun String.countIndexed(check: (item: Char, index: Int) -> Boolean): Int {
    var sum = 0
    for (i in indices) if (check.invoke(this[i], i)) sum++
    return sum
}

fun Int.squared() = this * this

private fun <T> String.list(delimiter: String, perform: String.() -> T): List<T> =
    removeSurrounding("[[", "]]").split(delimiter).map { it.perform() }

fun String.toIntArray() = list(",") { toInt() }.toIntArray()
fun String.toIntArrayArray() = list("],[") { toIntArray() }.toTypedArray()