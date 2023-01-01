
fun main() {
    val n = readLine()!!.toInt()

    val dp = MutableList<Int>(n + 1) { 0 }
    if (n <= 1) {
        println(n)
        return
    }
    dp[0] = 0
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007
    }
    println(dp[n])

}