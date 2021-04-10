object MergeSort : Problem.SORT() {
    override fun sort(nums: IntArray) = mergeSort(nums).run { nums }
    private fun mergeSort(nums: IntArray, left: Int = 0, right: Int = nums.size - 1) {
        if (right <= left) return
        val midPoint = (left + right) / 2
        mergeSort(nums, left, midPoint)
        mergeSort(nums, midPoint + 1, right)
        merge(nums, left, right)
    }

    private fun merge(nums: IntArray, left: Int, right: Int) {
        val midpoint = (left + right) / 2
        val leftSize = midpoint + 1 - left
        val rightSize = right - midpoint
        val arr1 = IntArray(leftSize) { nums[left + it] }
        val arr2 = IntArray(rightSize) { nums[midpoint + 1 + it] }
        var leftIndex = 0
        var rightIndex = 0
        var numIndex = left
        while (leftIndex < leftSize || rightIndex < rightSize) {
            if (rightIndex >= rightSize || (leftIndex < leftSize && arr1[leftIndex] <= arr2[rightIndex])) {
                nums[numIndex++] = arr1[leftIndex++]
                continue
            }
            nums[numIndex++] = arr2[rightIndex++]
        }
    }


}
