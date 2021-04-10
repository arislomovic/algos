import kotlin.collections.ArrayList
import kotlin.collections.HashSet

object ThreeSum : Problem.Medium() {

    private fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return listOf()
        val list = ArrayList<List<Int>>()
        val set = HashSet<Pair<Int, Int>>()
        for (index in 0..nums.size - 3) {
            val map = HashSet<Int>()
            val first = -nums[index]
            for (i in index + 1 until nums.size) {
                val second = nums[i]
                val third = first - second
                if (map.contains(third)) {
                    val arr = arrayOf(-first, second, third).apply { sort() }
                    if (set.add(arr[0] to arr[1])) list.add(listOf(*arr))
                } else map.add(second)
            }
        }
        return list
    }

    private fun threeSumSort(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return listOf()
        nums.sort()
        val list = ArrayList<List<Int>>()
        val set = HashSet<Pair<Int, Int>>()
        repeat(nums.size - 1) { index ->
            var start = index + 1
            var end = nums.size - 1
            val first = -nums[index]
            while (start < end) {
                val sum = nums[start] + nums[end]
                when {
                    sum > first -> end--
                    sum < first -> start++
                    sum == first -> {
                        val arr = arrayOf(-first, nums[start++], nums[end--]).apply { sort() }
                        if (set.add(arr[0] to arr[1])) list.add(arr.toList())
                    }
                }
            }
        }
        return list
    }

    override fun runProblem() = threeSumSort(testCases[0])

    override val testCases = arrayOf(
        intArrayOf(-1, 0, 1, 2, -1, -4),
        intArrayOf(2, 1, 3, -5, -1, -4),
        intArrayOf(1, 0, 3, 2, -1, 4, -4, 5, -5),
        intArrayOf(0),
        intArrayOf(0, 5),
        intArrayOf(0, 1, 5),
        intArrayOf(0, -5, 5, 0, -5, 5),
    )

    override fun runTestCases() = testCases.map { threeSumSort(it) }.forEach { it.print() }
}