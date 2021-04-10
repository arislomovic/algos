object LargestRectangle : Problem.Medium(84) {
    override fun runProblem() = largestRectangle()

    override val testCases = arrayOf(
        intArrayOf(2, 1, 5, 6, 2, 3),
        intArrayOf(2, 2, 6, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2),
        intArrayOf(2, 2, 6, 2, 2, 3, 10, 10, 11, 2, 2, 2, 2, 2, 2),
        intArrayOf(2, 2, 6, 2, 2, 3, 10, 10, 11),
    )

    private fun maxCombineArea(heights: IntArray, left: Int, right: Int): Int {
        val middle = left + (right - left) / 2
        var leftIndex = middle
        var rightIndex = middle + 1
        var area = 0
        var height = Integer.MAX_VALUE
        while (leftIndex >= left && rightIndex <= right) {
            height = minOf(height, heights[leftIndex], heights[rightIndex])
            area = maxOf(area, (rightIndex - leftIndex + 1) * height)
            when {
                leftIndex == left -> rightIndex++
                right == rightIndex -> leftIndex--
                // if both sides have not reached the boundary, compare outer bars and expand towards the bigger side
                heights[leftIndex - 1] > heights[rightIndex + 1] -> leftIndex--
                else -> rightIndex++
            }
        }
        return area
    }

    private fun maxArea(heights: IntArray, left: Int, right: Int): Int {
        // if the range only contains one bar, return its height as area
        if (left == right) return heights[left]
        // otherwise, divide & conquer, the max area must be among the following 3 values
        val middle = left + (right - left) / 2
        // 1 - max area from left half
        val leftArea = maxArea(heights, left, middle)
        // 2 - max area from right half
        val rightArea = maxArea(heights, middle + 1, right)

        val combined = maxCombineArea(heights, left, right)
        // 3 - max area across the middle
        return maxOf(rightArea, leftArea, combined)
    }

    private fun largestRectangleArea(heights: IntArray = intArrayOf(2, 1, 5, 6, 2, 3)): Int {
        if (heights.isEmpty()) return 0
        var max = 0
        val size = heights.size
        val stack = ArrayDeque<Int>(size)
        repeat(size) { i ->
            if (stack.isEmpty() || stack.last() <= heights[i]) stack.add(heights[i])
            var counter = 1
            while (stack.isNotEmpty() && (stack.last() > heights[i] || i == size - 1)) {
                max = maxOf(max, stack.removeLast() * counter++)
            }
        }
        return max
    }


    private fun largestRectangle(height: IntArray = testCases[0]) = if (height.isEmpty()) 0
    else maxArea(height, 0, height.size - 1)

    override fun runTestCases() = testCases.map { largestRectangle(it) }.forEach { println(it) }
}