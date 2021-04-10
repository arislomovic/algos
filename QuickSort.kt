object QuickSort : Problem.SORT() {
    override fun sort(nums: IntArray) = quickSort(nums).run { nums }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var smallerIndex = low - 1
        for (currentIndex in low until high) {
            if (arr[currentIndex] <= pivot) {
                arr.swap(++smallerIndex, currentIndex)
            }
        }
        arr.swap(smallerIndex + 1, high)
        return smallerIndex + 1
    }

    private fun quickSort(nums: IntArray, low: Int = 0, high: Int = nums.size - 1) {
        if (low >= high) return

        val partitioningIndex = partition(nums, low, high)

        quickSort(nums, low, partitioningIndex - 1)
        quickSort(nums, partitioningIndex + 1, high)
    }

}