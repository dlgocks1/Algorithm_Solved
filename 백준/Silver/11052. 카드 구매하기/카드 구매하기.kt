
import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val N = reader.readLine().toInt()
//    val moneys = reader.readLine().split(" ").map { it.toInt() }
//    val dp = Array(N + 1) { 0 }
    val dp = mutableListOf(0)
    dp.addAll(reader.readLine().split(" ").map { it.toInt() }.toMutableList())
    for (i in 1..N) {
        dp.forEachIndexed { index, money ->
            if (i - index > 0) {
                dp[i] = Math.max(dp[i - index] + money, dp[i])
            }
        }
    }

    println(dp[N])
}
