object PascalsTriangle : Problem.Medium(118) {
    override fun runProblem() = getRowOther().getString()
    private fun getRow(rowIndex: Int = 4): List<Int> {
        val arr = Array<ArrayList<Int>>(rowIndex + 1) { ArrayList(it + 1) }
        arr[0] = arrayListOf(1, 1)
        repeat(rowIndex) { i ->
            val list = arr[i - 1]
            arr[i].add(1)
            repeat(i - 1) { j ->
                arr[i].add(list[j] + list[j + 1])
            }
            arr[i].add(1)
        }
        return arr[rowIndex]
    }

    private fun getRowOther(rowIndex: Int = 4): List<Int> {
        var list = arrayListOf(1, 1)
        var size = 2
        while (size < rowIndex + 1) {
            val current = ArrayList<Int>(++size).apply { add(1) }
            repeat(size - 2) { j -> current.add(list[j] + list[j + 1]) }
            current.add(1)
            list = current
        }
        return list
    }

    private tailrec fun getRow(rowIndex: Int, list: ArrayList<Int>): ArrayList<Int> {
        val size = list.size
        if (rowIndex + 1 == size) return list
        val mList = ArrayList<Int>(size + 1)
        mList.add(1)
        repeat(size - 1) { i -> mList.add(list[i] + list[i + 1]) }
        mList.add(1)
        return getRow(rowIndex, mList)
    }
}