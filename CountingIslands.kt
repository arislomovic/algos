object CountingIslands : Problem.Medium(200) {
    //Given a binary matrix where 0 represents water and 1 represents land, count the number of islands in it. An island
    // is formed by connected 1's. The idea is to start BFS from each unprocessed node and increment the island count.
    // Each BFS traversal will mark all cells which make one island as processed.

    override fun runProblem() = numIslands(testCases[0])

    private fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isNullOrEmpty()) return 0
        var level = 0
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] != '1') continue
                level++
                dfs(grid, row, col)
            }
        }
        return level
    }

    private fun dfsRecursive(grid: Array<CharArray>, row: Int, col: Int) {
        if (!grid.isSafe(row, col, '1')) return
        grid[row][col] = '0'
        dfs(grid, row + 1, col)
        dfs(grid, row - 1, col)
        dfs(grid, row, col + 1)
        dfs(grid, row, col - 1)
    }

    private fun dfs(grid: Array<CharArray>, row: Int, col: Int) {
        val rowAmount = grid.size
        val columnAmount = grid[0].size
        val stack = arrayDequeOf(row to col)
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            grid[current.first][current.second] = '0'
            var movement = current.first + 1
            while (movement < rowAmount && grid[movement][current.second] == '1') {
                grid[movement][current.second] = '0'
                stack.addLast(movement++ to current.second)
            }
            movement = current.first - 1
            while (movement >= 0 && grid[movement][current.second] == '1') {
                grid[movement][current.second] = '0'
                stack.addLast(movement-- to current.second)
            }
            movement = current.second + 1
            while (movement < columnAmount && grid[current.first][movement] == '1') {
                grid[current.first][movement] = '0'
                stack.addLast(current.first to movement++)
            }
            movement = current.second - 1
            while (movement >= 0 && grid[current.first][movement] == '1') {
                grid[current.first][movement] = '0'
                stack.addLast(current.first to movement--)
            }
        }
    }

    private fun bfs(grid: Array<CharArray>) = grid.bfs()

    override val testCases = arrayOf(
        arrayOf(
            charArrayOf('1', '0', '1', '0', '0', '0', '1', '1', '1', '1'),
            charArrayOf('0', '0', '1', '0', '1', '0', '1', '0', '0', '0'),
            charArrayOf('1', '1', '1', '1', '0', '0', '1', '0', '0', '0'),
            charArrayOf('1', '0', '0', '1', '0', '1', '0', '0', '0', '0'),
            charArrayOf('1', '1', '1', '1', '0', '0', '0', '1', '1', '1'),
            charArrayOf('0', '1', '0', '1', '0', '0', '1', '1', '1', '1'),
            charArrayOf('0', '0', '0', '0', '0', '1', '1', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '0', '0', '1', '1', '1', '0'),
            charArrayOf('1', '0', '1', '0', '1', '0', '0', '1', '0', '0'),
            charArrayOf('1', '1', '1', '1', '0', '0', '0', '1', '1', '1')
        ),
        arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        ),
        arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        ),
        arrayOf(
            charArrayOf('0', '0', '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'),
            charArrayOf('0', '1', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '0'),
            charArrayOf('0', '1', '0', '0', '1', '1', '0', '0', '1', '0', '1', '0', '0'),
            charArrayOf('0', '1', '0', '0', '1', '1', '0', '0', '1', '1', '1', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0')
        )
    )

}

