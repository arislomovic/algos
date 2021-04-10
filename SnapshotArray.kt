object SnapshotArray : Problem.Medium(1146) {
    private class SnapshotArray(length: Int) {

        private val list = HashMap<Int, HashMap<Int, Int>>()
        var snaps = -1

        init {
            list[snaps] = HashMap(length)
        }

        fun set(index: Int, `val`: Int) = apply {
            list[snaps]!![index] = `val`
        }

        fun snap(): Int {
            list[snaps + 1] = HashMap(list[snaps].orEmpty())
            return snaps++
        }

        fun get(index: Int, snap_id: Int)  = list[snap_id -1]?.getOrDefault(index, 0)
    }
}