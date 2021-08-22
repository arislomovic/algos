object RansomNote : Problem.Easy(383) {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineMap: HashMap<Char, Int> = HashMap()
        for (c in magazine) {
            magazineMap[c] = (magazineMap[c] ?: 0) + 1
        }
        for (c in ransomNote) {
            val quantity = magazineMap[c] ?: return false
            if (quantity == 0) {
                return false
            }
            magazineMap[c] = quantity - 1
        }
        return true
    }
}