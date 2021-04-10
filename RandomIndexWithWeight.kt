object RandomIndexWithWeight : Problem.Medium(528) {
    private class Solution(val w: IntArray) {
        private var sums = IntArray(w.size)
        private var totalSum = 0

        init {
            for (i in w.indices) {
                totalSum += w[i]
                sums[i] += totalSum
            }
        }

        private fun pickIndex(): Int {
            //Next Double returns a number between 0 and 1
            val target = (totalSum * nextDouble()).toInt()
            var low = 0
            //Prefix Sums are a sorted array of every % of the total each item in W represents
            var high: Int = sums.size
            while (low < high) {
                // better to avoid the overflow
                val mid = low + (high - low) / 2
                if (target > sums[mid]) low = mid + 1 else high = mid
            }
            return low
        }

        val test = HashMap<Int, Int>().apply {
            repeat(100) { pickIndex().let { this[it] = getOrDefault(it, 0) + 1 } }
        }.toString().run { w.getString() + "\n$this" }

    }


    override fun runProblem() = IntArray(20) { nextInt(0, 100) }.run { Solution(this).test }

}