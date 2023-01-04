fun main() {
    val N = readLine()!!
    val M = readLine()!!
    val dp = MutableList(N.length + 1) { MutableList(M.length + 1) { 0 } }

    var answer = 0
    for (i in 1..N.length) {
        for (j in 1..M.length) {
            if (M[j - 1] == N[i - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
            answer = Math.max(answer, dp[i][j])
        }
    }
    println(answer)

}