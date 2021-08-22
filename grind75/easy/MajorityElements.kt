package grind75.easy

object MajorityElements : Problem.Medium(169) {
    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            val mNum = (map[num] ?: 0) + 1
            if (mNum > nums.size / 2) {
                return num
            }
            map[num] = mNum
        }
        return 0
    }
}