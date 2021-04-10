object FizzBuzz : Problem.Easy(412) {
    private fun fizzBuzz(n: Int) = (1..n).map {
        when {
            it % 3 != 0 && it % 5 != 0 -> it.toString()
            it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
            it % 3 == 0 -> "Fizz"
            else -> "Buzz"
        }
    }

    override fun runProblem() = fizzBuzz(15)
}