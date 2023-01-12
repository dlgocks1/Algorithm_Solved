import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (n, k) = reader.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1) { 0 }
    dp[0] = 1
    val coins = IntArray(n) { 0 }
    repeat(n) {
        coins[it] = reader.readLine().toInt()
    }
    coins.forEach { coin ->
        for (i in 0..k) {
            if (i - coin >= 0) {
                dp[i] += dp[i - coin]
            }
        }
    }
//    dp.forEach {
//        print(it)
//    }

    println(dp[k])
}