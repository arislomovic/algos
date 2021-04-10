package fb

import arrayDequeOf

object ContiguousSubArrays:Problem.Misc() {
    fun countSubarrays(arr: IntArray): IntArray {
        val n = arr.size
        val output = IntArray(n) { 1 }
        val stack = arrayDequeOf(-1, 0)
        for (i in 1 until n) {
            while (stack.last() != -1 && arr[i] > arr[stack.last()]) stack.removeLast()
            output[i] += i - stack.last() - 1
            stack.add(i)
        }
        stack.clear()
        stack.add(n)
        stack.add(n - 1)
        for (i in n - 2 downTo 0) {
            while (stack.last() != n && arr[i] > arr[stack.last()]) stack.removeLast()
            output[i] += stack.last() - i - 1
            stack.add(i)
        }
        return output
    }
}