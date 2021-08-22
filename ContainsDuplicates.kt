object ContainsDuplicates : Problem.Easy(217) {
    fun containsDuplicate(nums: IntArray) = nums.toHashSet().size != nums.size

}