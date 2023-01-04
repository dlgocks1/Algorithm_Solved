
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val boxs = reader.readLine().split(" ").map { it.toInt() }
    val dp = Array<Int>(n) { 1 }

    for (i in boxs.indices) {
        for (j in 0..i) {
            if (boxs[i] > boxs[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
    }
    println(dp.maxOrNull())
}