package grind75.easy

import ListNode
import Problem
import buildListNodes

object MergeTwoLists : Problem.Easy(21) {
    private fun mergeTwoListsRecursively(l1: ListNode? = ListNode(1), l2: ListNode? = ListNode(2)): ListNode? {
        l1 ?: return l2
        l2 ?: return l1
        return if (l1.`val` > l2.`val`) l2.apply { next = mergeTwoListsRecursively(l1, l2.next) }
        else l1.apply { next = mergeTwoListsRecursively(l1.next, l2) }
    }


    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        // maintain an unchanging reference to node ahead of the return node.
        var newL1: ListNode? = l1 ?: return l2
        var newL2: ListNode? = l2 ?: return l1
        val headHolder = ListNode(-1)

        var prev: ListNode? = headHolder
        while (newL1 != null && newL2 != null) {
            if (newL1.`val` <= newL2.`val`) {
                //FIRST TIME THIS IS CALLED, HEADHOLDER'S NEXT IS SET TOO, BECAUSE OF PASS BY REFERENCE
                prev?.next = newL1
                newL1 = newL1.next
            } else {
                //FIRST TIME THIS IS CALLED, HEADHOLDER'S NEXT IS SET TOO, BECAUSE OF PASS BY REFERENCE
                prev?.next = newL2
                newL2 = newL2.next
            }
            prev = prev?.next
        }

        prev?.next = newL1 ?: newL2

        return headHolder.next
    }

    override val testCases = arrayOf(
        buildListNodes(1, 3, 7, 9, 12),
        buildListNodes(1, 4, 7, 12, 13),
        buildListNodes(1, 2, 4),
        ListNode(5),
        buildListNodes(-9, 3),
        buildListNodes(5, 7)
    )

    override fun runTestCases() = run {
        repeat(testCases.size - 1) { i ->
            for (j in i + 1 until testCases.size) {
                mergeTwoLists(testCases[i], testCases[j])
                mergeTwoLists(testCases[j], testCases[i])
            }
        }
    }


    override fun runProblem() = mergeTwoLists(testCases[0], testCases[1])?.toString().orEmpty()
}


