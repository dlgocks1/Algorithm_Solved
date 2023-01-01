
fun main() {
    val X = readLine()!!.toInt()

    if (X == 1) {
        println(0)
        return
    }
    if (X <= 3) {
        println(1)
        return
    }
    val dp = MutableList<Int>(X + 1) { Int.MAX_VALUE }
    dp[0] = 0
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1

    for (i in 4 until X + 1) {
        if (i % 3 == 0) {
            dp[i] = Math.min(dp[i / 3] + 1, dp[i])
        }
        if (i % 2 == 0) {
            dp[i] = Math.min(dp[i / 2] + 1, dp[i])
        }
        dp[i] = Math.min(dp[i - 1] + 1, dp[i])
    }

    println(dp[X])
}