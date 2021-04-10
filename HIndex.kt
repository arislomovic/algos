object HIndex : Problem.Medium(274) {
    fun hIndex(citations: IntArray): Int {//6, 0, 6, 4, 5
        citations.sort()// 0, 4, 5, 6, 6,
        repeat(citations.size) { i ->
            //6>0...OK -> 6>1...OK -> 5>2...OK -> 4>3...OK...0<4...RETURN 4
            if (citations[citations.size - 1 - i] <= i) return i
        }
        return 0
    }

    //Any citation larger than n can be replaced by n and the h-index will not change after the replacement
    fun hIndexCounting(citations: IntArray): Int {
        var end: Int = citations.size
        //SIZE + 1 to account for all numbers greater than n.size
        val papers = IntArray(end + 1)
        // counting papers for each citation number
        for (c in citations) papers[minOf(end, c)]++
        // finding the h-index
        var sum = papers[end]
        while (end > sum) {
            sum += papers[--end]
        }
        return end
    }

    override fun runProblem() = hIndexCounting(intArrayOf(6, 0, 6, 4, 5))
}