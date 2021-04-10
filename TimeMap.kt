import java.util.*

object TimeMap : Problem.Medium(981) {

    internal class TimeMap : HashMap<String, TreeMap<Int, String>>() {

        fun set(key: String, value: String, timestamp: Int) {
            if (!containsKey(key)) this[key] = TreeMap(comparator)
            this[key]!![timestamp] = value
        }

        fun get(key: String, timestamp: Int) = this[key]?.run {
            getOrDefault(timestamp, lowerEntry(timestamp)?.value.orEmpty())
        }.orEmpty()
    }


    override val testCases = arrayOf(
            TimeMap().apply {
                set("foo", "bar", 1)
                get("foo", 1)
                get("foo", 0)
                set("foo", "bar2", 4)
                get("foo", 4)
                get("foo", 5)
            }
    )
}