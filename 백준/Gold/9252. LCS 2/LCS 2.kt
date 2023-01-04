import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val N = reader.readLine()
    val M = reader.readLine()
    var i = N.length
    var j = M.length
    val dp = Array(i + 1) { Array(j + 1) { 0 } }
    for (i in 1..i) {
        for (j in 1..j) {
            if (M[j - 1] == N[i - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[i][j])
    if (dp[i][j] == 0) return
    val LCS = java.lang.StringBuilder()

    while (i > 0 && j > 0) {
        if (N[i - 1] == M[j - 1]) {
            LCS.append(N[i - 1])
            i--
            j--
            continue
        }
        if (dp[i - 1][j] == dp[i][j]) {
            i--
        } else if (dp[i][j - 1] == dp[i][j]) {
            j--
        }
    }
    for (i in LCS.toString().reversed()) {
        print(i)
    }
}