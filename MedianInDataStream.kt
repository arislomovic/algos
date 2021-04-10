import kotlin.collections.ArrayList

object MedianInDataStream : Problem.Hard(295) {
    class MedianFinder() {

        /** initialize your data structure here. */
        private val list = mutableListOf<Int>()

        fun addNum(num: Int) {
            val index = list.binarySearch(num)
            if (index < 0) list.add(-index - 1, num)
            else list.add(index, num)
        }

        fun findMedian(): Double {
            if (list.isEmpty()) return 0.0

            val mid = list.lastIndex / 2
            val midNumber = list[mid].toDouble()
            return if (list.size % 2 == 0) (midNumber + list[mid + 1].toDouble()) / 2.0
            else list[mid].toDouble()
        }

    }
}