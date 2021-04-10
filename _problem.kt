import kotlin.random.Random

//Separate classes will allow us to filter the problems based on types
sealed class Problem private constructor(val id: Int = 0) {

    open class Easy(id: Int = 0) : Problem(id)
    open class Medium(id: Int = 0) : Problem(id)
    open class Hard(id: Int = 0) : Problem(id)
    open class Misc : Problem()

    protected val comparator = Comparator<Int> { o1, o2 -> o1 - o2 }
    fun nextInt() = Random.nextInt()
    fun nextDouble() = Random.nextDouble()
    fun nextInt(until: Int) = Random.nextInt(until)
    fun nextInt(from: Int, until: Int) = Random.nextInt(from, until)

    open class SORT(id: Int = -1) : Problem.Medium(id) {
        open fun sort(nums: IntArray): IntArray = nums
        override fun runProblem() = buildString {
            val arr = IntArray(20) { nextInt(100) }
            appendLine(arr.getString())
            appendLine(sort(arr).getString())
        }
    }

    companion object {
        val DIRECTIONS = intArrayOf(0, 1, 0, -1, 0)
        val ALL_DIRECTIONS = arrayOf(0, 1, -1)
    }

    fun run() = println("${this::class.simpleName}: ${runProblem()}")
    open fun runTestCases(): Any? = Unit
    internal open val testCases: Array<*> = arrayOf("")
    protected open val mainTestcase get() = testCases[0]
    protected open fun runProblem(): Any? = "N/A"
}