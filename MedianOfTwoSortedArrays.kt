object MedianOfTwoSortedArrays : Problem.Medium(4) {
    override fun runProblem() = findMedianSortedArrays()
    private fun findMedianSortedArrays(nums1: IntArray = testCases[0], nums2: IntArray = testCases[1]): Double {
        var median1 = -1
        var median2 = -1
        var index1 = 0
        var index2 = 0
        val size1 = nums1.size
        val size2 = nums2.size
        for (count in 0..(size1 + size2) / 2) {
            median2 = median1
            median1 = when {
                index1 == size1 -> nums2[index2++]
                index2 == size2 -> nums1[index1++]
                nums1[index1] > nums2[index2] -> nums2[index2++]
                else -> nums1[index1++]
            }
        }
        return if (size1 + size2 % 2 == 1) median1.toDouble()
        else (median1 + median2) / 2.0
    }

    override val testCases = arrayOf(
        intArrayOf(1, 2, 3, 4, 20, 21, 22, 23),
        intArrayOf(5, 6, 7, 8, 9, 10, 11, 12)
    )

}