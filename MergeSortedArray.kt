object MergeSortedArray : Problem.Medium(88) {
    private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
        var i1 = m - 1
        var i2 = n - 1
        while (i1 + i2 >= -1) {
            nums1[i1 + i2 + 1] =
                if (i1 >= 0 && (i2 < 0 || nums1[i1] > nums2[i2])) nums1[i1--]
                else nums2[i2--]

        }
        return nums1
    }

    override val mainTestcase get() = testCases.last()
    override fun runProblem() =
        merge(
            mainTestcase[0].first,
            mainTestcase[0].second,
            mainTestcase[1].first,
            mainTestcase[1].second
        ).toList()

    override val testCases = arrayOf(
        arrayOf(
            intArrayOf(1, 2, 3, 0, 0, 0) to 3,
            intArrayOf(2, 5, 6) to 3
        ),
        arrayOf(
            intArrayOf(1, 2, 3, 0, 0, 0) to 3,
            intArrayOf(4, 5, 6) to 3
        ),
        arrayOf(
            intArrayOf(1, 2, 3, 0, 0, 0) to 3,
            intArrayOf(3, 5, 6) to 3
        ),
        arrayOf(
            intArrayOf(1) to 1,
            intArrayOf() to 0
        ),
        arrayOf(
            intArrayOf(0) to 1,
            intArrayOf() to 0
        ),
        arrayOf(
            intArrayOf(0) to 0,
            intArrayOf(1) to 1
        ),
    )
}