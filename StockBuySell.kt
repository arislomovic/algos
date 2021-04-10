object StockBuySell : Problem.Easy(121) {
    override fun runProblem() = maxProfit(intArrayOf())
    private fun maxProfit(prices: IntArray): Int {
        var minPrice = Integer.MAX_VALUE
        var profit = 0
        for (i in prices) {
            if (i < minPrice) minPrice = i
            else profit = maxOf(profit, i - minPrice)
        }
        return profit
    }
}