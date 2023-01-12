import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val dp = Array(n + 1) { 0 }
    if (n < 4) {
        println(n)
        return
    }
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    for (i in 4..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }

    println(dp[n])


}