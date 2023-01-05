import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val str1 = reader.readLine()
    val str2 = reader.readLine()
    val dp = Array(str1.length + 1) { IntArray(str2.length + 1) { 0 } }
    var answer = 0

    for (i in 1..str1.length) {
        for (j in 1..str2.length) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                answer = Math.max(answer, dp[i][j])
            }
        }
    }
    writer.write(answer.toString())
    writer.flush()
}