object FloodFill : Problem.Easy() {
    private fun floodFill(
            image: Array<IntArray> = testCases[0],
            sr: Int = 1,
            sc: Int = 1,
            newColor: Int = 1
    ): Array<IntArray> {
        if (image.isEmpty() || image[0].isEmpty() || image[sr][sc] == newColor) return image
        val rows = image.size
        val col = image[0].size
        val originalColor = image[sr][sc]
        val stack: ArrayDeque<IntArray> = arrayDequeOf(intArrayOf(sr, sc))
        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            if (image[current[0]][current[1]] == newColor) continue
            var movement: Int = current[0] + 1

            while (movement < rows && image[movement][current[1]] == originalColor) {
                stack.addFirst(intArrayOf(movement++, current[1]))
            }

            movement = current[0] - 1

            while (movement >= 0 && image[movement][current[1]] == originalColor) {
                stack.addFirst(intArrayOf(movement--, current[1]))
            }

            movement = current[1] + 1

            while (movement < col && image[current[0]][movement] == originalColor) {
                stack.addFirst(intArrayOf(current[0], movement++))
            }

            movement = current[1] - 1

            while (movement >= 0 && image[current[0]][movement] == originalColor) {
                stack.addFirst(intArrayOf(current[0], movement--))
            }

            image[current[0]][current[1]] = newColor
        }
        return image
    }

    override val testCases = arrayOf(
            arrayOf(
                    intArrayOf(0, 0, 0),     intArrayOf(0, 1, 1)
            )
    )

    override fun runProblem() = buildString {
        for (arr in floodFill()) {
            for (intArr in arr) append(intArr)
            appendLine()
        }
    }
}