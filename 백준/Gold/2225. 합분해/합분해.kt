import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (N, K) = reader.readLine().split(" ").map { it.toInt() }
    val nums = Array(N + 1) { it }
    val dp = Array(N + 1) { Array(K + 1) { 0 } }
    for (i in 0..K) {
        dp[1][i] = i
    }
    for (i in 2..N) {
        for (j in 0..K) {
            if (j == 0) continue
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000
        }
    }
    println(dp[N][K])

//    dp[1][0] = 0
//    dp[1][1] = 1
//    dp[1][2] = 2 // 0 1 / 1 0
//    dp[1][3] = 3 // 0 0 1 / 0 1 0 / 1 0 0
//    dp[1][4] = 4
    // ....
//    dp[2][0] = 0
//    dp[2][1] = 1 // 2
//    dp[2][2] = 3 // 1,1 / 0,2 / 2,0
//    dp[2][3] = 6 // 0 1 1 / 1 0 1 / 1 1 0 / 2 0 0 / 0 2 0 / 0 0 2


} 