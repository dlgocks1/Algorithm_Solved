import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val N = reader.readLine().toInt()
    val cards = reader.readLine().split(" ").map { it.toInt() }
    val dp = Array(N) { 1 }

    for (now in cards.indices) {
        for (iterator in 0..now) {
            if (cards[now] > cards[iterator]) {
                dp[now] = Math.max(dp[iterator] + 1, dp[now])
            }
        }
    }
    println(dp.maxOrNull())
}