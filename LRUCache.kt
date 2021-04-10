object LRUCache : Problem.Medium(146) {
    private const val DEFAULT_LOAD_FACTOR = .75f

    internal data class LRUCache(private val capacity: Int) : LinkedHashMap<Int, Int>(capacity, DEFAULT_LOAD_FACTOR, true) {
        override fun get(key: Int) = super.getOrDefault(key, -1)
        override fun removeEldestEntry(eldest: Map.Entry<Int, Int>) = size > capacity
    }

    internal data class LRUCache2(private val capacity: Int) : LinkedHashMap<Int, Int>() {
        override fun get(key: Int): Int = removeOrDefault(key, -1).also { this[key] = it }
        override fun put(key: Int, value: Int): Int? {
            if (capacity == size && !containsKey(key)) remove(iterator().next().key)
            return super.put(key, value)
        }
    }

    override fun runProblem() = LRUCache(3).run {
        put(1, 1)
        put(2, 2)
        get(1)
    }
}