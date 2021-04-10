object UglyNumberII:Problem.Medium(264) {
    override fun runProblem() = getNthUglyNo(24)

    private fun getNthUglyNo(n: Int): Int {
        val ugly = IntArray(n).apply { this[0] = 1 }
        //Keeps track of the lowest number by which the respective numbers must be must be multiplied to be the next lowest
        //of it. e.g. 1X2, 1X3, 1X5, 2X2, 3X3, 2X5... etc
        var i2 = 0
        var i3 = 0
        var i5 = 0
        //Keeps track of next lowest multiple, for comparison
        var next2 = 2
        var next3 = 3
        var next5 = 5
        for (i in 1 until n) {
            ugly[i] = minOf(next2, next3, next5)
            if (ugly[i] == next2) next2 = ugly[++i2] * 2
            if (ugly[i] == next3) next3 = ugly[++i3] * 3
            if (ugly[i] == next5) next5 = ugly[++i5] * 5
            println(ugly.toList())
        }
        return ugly[n - 1]
    }

}