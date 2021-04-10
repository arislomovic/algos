object MergeKLists : Problem.Hard(23) {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        for (i in 0 until lists.size - 1) {
            lists[i + 1] = MergeTwoLists.mergeTwoLists(lists[i], lists[i + 1])
        }
        return lists.last()
    }
}