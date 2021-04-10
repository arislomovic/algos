object RandomizedSet : Problem.Medium(380) {
    internal class RandomizedSet {

        private val list = ArrayList<Int>()
        private val map = HashMap<Int, Int>()

        fun insert(`val`: Int): Boolean {
            if (map.containsKey(`val`)) return false
            map[`val`] = list.size
            return list.add(`val`)
        }

        fun remove(`val`: Int): Boolean {
            val index = map.remove(`val`) ?: return false
            // move the last element to the place idx of the element to delete
            map[list.last()] = index
            list[index] = list.removeLast()
            return true
        }

        fun getRandom() = list.random()

    }

    override fun runProblem() = testCases.run { print(this[0]) }

    override val testCases = arrayOf(
            RandomizedSet().apply {
                insert(1)
                insert(2)
                remove(1)
                getRandom()
            }
    )

}