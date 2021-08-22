import java.util.*

fun IntArray.swap(i: Int, j: Int) {
    if (i == j) return
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun IntArray.sortInPlace() = apply { sort() }
fun IntArray.distanceTo(p2: IntArray): Int = distanceTo(p2[0], p2[1])
fun IntArray.distanceTo(x: Int, y: Int) = (y - this[1]).squared() + (x - this[0]).squared()
fun <T : AbstractMap<Int, Int>> IntArray.countOccurrences(map: T) =
    map.also { for (i in this) it[i] = it.getOrDefault(i, 0) + 1 }
fun IntArray.binSearch(target: Int): Boolean {
    var low = 0
    var high: Int = size
    while (high > low) {
        val mid = (high + low) / 2
        if (this[mid] == target) return true
        if (this[mid] > target) low = mid + 1
        else high = mid - 1
    }
    return false
}

fun IntArray.countIndexed(check: (item: Int, index: Int) -> Boolean): Int {
    var sum = 0
    for (i in indices) if (check.invoke(this[i], i)) sum++
    return sum
}