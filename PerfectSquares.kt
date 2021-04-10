object PerfectSquares : Problem.Medium(279) {

    private fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { it }
        for (num in 1..n) {
            var factor = 0
            while (factor * factor <= num) {
                dp[num] = minOf(dp[num], 1 + dp[num - factor * factor])
                factor++
            }
        }

        return dp[n]
    }

    override fun runProblem() = numSquares(12)
}
/*
dp[0] = 0
dp[1] = dp[0]+1 = 1
dp[2] = dp[1]+1 = 2
dp[3] = dp[2]+1 = 3
dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
      = Min{ dp[3]+1, dp[0]+1 }
      = 1
dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
      = Min{ dp[4]+1, dp[1]+1 }
      = 2
						.
						.
						.
dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
       = 2
						.
						.
						.
dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
 */