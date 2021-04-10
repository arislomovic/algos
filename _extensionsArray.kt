import java.util.*

fun <T> Array<T>.swap(i: Int, j: Int) {
    if (i == j) return
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun Array<CharArray>.isSafe(x: Int, y: Int, c: Char) = isSafe(x, y) && this[x][y] == c
fun Array<CharArray>.isSafe(x: Int, y: Int) = isSafe(x, size, y, this[0].size)
fun Array<IntArray>.isSafe(x: Int, y: Int, i: Int) = isSafe(x, y) && this[x][y] == i
fun Array<IntArray>.isSafe(x: Int, y: Int) = isSafe(x, size, y, this[0].size)
fun Array<IntArray>.getTestCase() = map { it.toList() }.toString()
fun Array<IntArray>.sortIntPairs() = apply {
    Arrays.sort(this) { o1, o2 -> if (o1[0] == o2[0]) o1[1] - o2[1] else o1[0] - o2[0] }
}

fun <T> Array<T>.countOccurrences(map: AbstractMap<T, Int> = HashMap<T, Int>()) =
    map.also { for (i in this) it[i] = it.getOrDefault(i, 0) + 1 }


fun <T> Array<T>.getArrayString(): String = let { arr ->
    buildString {
        appendLine()
        arr.forEach { i -> appendLine(i.getString()) }
    }
}

fun <T> Array<T>.countIndexed(check: (item: T, index: Int) -> Boolean): Int {
    var sum = 0
    for (i in indices) if (check.invoke(this[i], i)) sum++
    return sum
}

fun Array<CharArray>.bfs(): Pair<Int, Int> {
    var counter = 0
    var maxSize = 0
    for (row in indices) {
        for (col in this[0].indices) {
            if (this[row][col] == '0') continue
            this[row][col] = '0'
            counter++
            val size = bfs(row, col) { x, y -> isSafe(x, y, '1').also { if (it) this[x][y] = '0' } }
            maxSize = maxOf(maxSize, size)
        }
    }
    return counter to size
}

fun Array<IntArray>.bfs(): Pair<Int, Int> {
    var counter = 0
    var maxSize = 0
    for (row in indices) {
        for (col in this[0].indices) {
            if (this[row][col] == 0) continue
            this[row][col] = 0
            counter++
            val size = bfs(row, col) { nextX, nextY -> isSafe(nextX, nextY, 1).also { if (it) this[nextX][nextY] = 0 } }
            maxSize = maxOf(maxSize, size)
        }
    }
    return counter to maxSize
}
