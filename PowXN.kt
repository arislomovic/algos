import kotlin.math.abs


object PowXN : Problem.Medium(50) {
    private fun myPow(x: Double, n: Int) =
        fastPow(x, n.toLong())


    private fun fastPow(x: Double, n: Long): Double {
        if (n == 0L) return 1.0
        val half = fastPow(x, n / 2)
        return if (n % 2 == 0L) half * half
        else half * half * x
    }

    private fun fastPowIteratively(x: Double, n: Long): Double {
        if (n == 0L) return 1.0
        if (n == 1L) return x
        var pow = abs(n)
        var result = 1.0
        var mX = x
        while (pow > 0 ) {
            if (pow % 2 != 0L) result *= mX
            mX *= mX
            pow /= 2
        }

        return if (n < 0) 1.0 / result else result
    }
    override fun runProblem() = myPow(2.0, 10)
}