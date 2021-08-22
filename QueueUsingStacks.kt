import java.util.*

object QueueUsingStacks : Problem.Easy(232) {
    class MyQueue {
        private val s1 = Stack<Int>()
        private val s2 = Stack<Int>()

        // Push element x to the back of queue.
        fun push(x: Int) {
            s1.push(x)
        }

        // Removes the element from in front of queue.
        fun pop() {
            moveFromS1ToS2()
            s2.pop()
        }

        // Get the front element.
        fun peek(): Int {
            moveFromS1ToS2()
            return s2.peek()
        }

        private fun moveFromS1ToS2() {
            if (s2.isEmpty()) {
                while (s1.isNotEmpty()) {
                    s2.push(s1.pop())
                }
            }
        }

        // Return whether the queue is empty.
        fun empty() = s1.isEmpty() && s2.isEmpty()
    }
}