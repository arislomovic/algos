object AlienDictionary : Problem.Easy(953) {
    override fun runProblem() = isAlienSorted()
    private fun isAlienSorted(words: Array<String> = testCases[2].first, order: String = testCases[2].second): Boolean {
        val map = HashMap<Char, Int>().apply { for (i in order.indices) this[order[i]] = i }
        repeat(words.size - 1) search@{ i ->
            val word1 = words[i]
            val word2 = words[i + 1]
            val length1 = word1.length
            val length2 = word2.length
            repeat(minOf(length1, length2)) runner@{ k ->
                if (word1[k] == word2[k]) return@runner
                // If they compare badly, it's not sorted.
                if (map[word1[k]]!! > map[word2[k]]!!) return false
                return@search
            }
            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (length1 > length2) return false
        }
        return true
    }

    override val testCases = arrayOf(
        arrayOf("hello", "leetcode") to "hlabcdefgijkmnopqrstuvwxyz",
        arrayOf("apple", "app") to "abcdefghijklmnopqrstuvwxyz",
        arrayOf("word", "world", "row") to "worldabcefghijkmnpqstuvxyz",
    )
}