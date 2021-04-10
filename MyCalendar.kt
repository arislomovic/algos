import java.util.*

object MyCalendar : Problem.Medium(729) {
    private class MyCalendar : TreeMap<Int, Int>() {
        fun book(start: Int, end: Int): Boolean {
            val prevStart = floorEntry(start)?.value
            val nextStart = ceilingKey(start)
            if (prevStart != null && prevStart > start || (nextStart != null && nextStart < end)) return false
            this[start] = end
            return true
        }
    }

    override fun runProblem() = MyCalendar().run {
        buildString {
            appendLine(book(10, 20))
            appendLine(book(15, 25))
            appendLine(book(20, 30))
            appendLine(book(5, 10))
            appendLine(book(1, 6))
        }
    }
}