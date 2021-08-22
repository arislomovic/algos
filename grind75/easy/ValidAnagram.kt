package grind75.easy

object ValidAnagram : Problem.Easy(242) {
    fun isAnagram(s: String, t: String): Boolean {
        if (t.length != s.length) return false
        val sMap = HashMap<Char, Int>()
        val tMap = HashMap<Char, Int>()

        for (c in s) {
            sMap[c] = (sMap[c] ?: 0) + 1
        }
        for (c in t) {
            tMap[c] = (tMap[c] ?: 0) + 1
        }
        return tMap == sMap
    }
}