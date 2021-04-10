import kotlin.collections.ArrayList
import kotlin.collections.HashSet

object ThreeSum : Problem.Medium(15) {

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


    fun twoSumSorted(start: Int, nums: IntArray, total: Int, unique: HashSet<Pair<Int, Int>>): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        val diff = total - nums[start]
        var startIndex = start + 1
        var endIndex = nums.size - 1
        while (startIndex < endIndex) {
            when {
                nums[startIndex] + nums[endIndex] < diff -> startIndex++
                nums[startIndex] + nums[endIndex] > diff -> endIndex--
                else -> {
                    val list = listOf(nums[startIndex++], nums[endIndex--], nums[start])
                    if (unique.add(list.minOrNull()!! to list.maxOrNull()!!)) ans.add(list)
                }
            }
        }
        return ans
    }

    private fun threeSumSort(nums: IntArray, total: Int): List<List<Int>> {
        if (nums.size < 3) return listOf()
        nums.sort()
        val list = ArrayList<List<Int>>()
        val set = HashSet<Pair<Int, Int>>()
        for (index in 0..nums.size - 3) {
            list.addAll(twoSumSorted(index, nums, total, set))
        }
        return list
    }

    override fun runProblem() = threeSumSort(testCases[0], 0)

    override val testCases = arrayOf(
        intArrayOf(-1, 0, 1, 2, -1, -4),
        intArrayOf(2, 1, 3, -5, -1, -4),
        intArrayOf(1, 0, 3, 2, -1, 4, -4, 5, -5),
        intArrayOf(0),
        intArrayOf(0, 5),
        intArrayOf(0, 1, 5),
        intArrayOf(0, -5, 5, 0, -5, 5),
    )

    override fun runTestCases() = testCases.map { threeSumSort(it, 0) }.forEach { it.print() }
}