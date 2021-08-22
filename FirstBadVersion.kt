object FirstBadVersion : Problem.Easy(278) {
    class Solution : VersionControl() {
        fun firstBadVersion(n: Int): Int {
            var start = 1
            var end = n
            while (start < end) {
                val mid = start + (end - start) / 2 // to prevent overflow
                if (isBadVersion(mid)) end = mid
                else start = mid + 1
            }
            return start
        }
    }
}