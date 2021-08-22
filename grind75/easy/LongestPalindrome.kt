package grind75.easy

object LongestPalindrome : Problem.Easy(409) {
    fun longestPalindrome(s: String): Int {
        if (s.length < 2) return s.length
        val set = HashSet<Char>()
        var counter = 0
        for (c in s) {
            if (set.add(c)) continue
            set.remove(c)
            counter += 2
        }
        return if (set.isNotEmpty()) counter + 1 else counter
    }
}
