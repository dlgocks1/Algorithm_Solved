import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (N, M, K) = reader.readLine().split(" ").map { it.toInt() }

    var dp = Array(N) { IntArray(M) { 1 } }
    // K == 3일 때

    val targetY = if(K == 0) 0 else (K-1) / M
    val targetX = if(K == 0) 0 else (K-1) % M

//    println(targetX)
//    println(targetY)
    for(y in 1 .. targetY){
        for(x in 1  .. targetX) {
            dp[y][x] = dp[y-1][x] + dp[y][x-1]
        }
    }
    val hap1 = dp[targetY][targetX]
    dp = Array(N) { IntArray(M) { 1 } }

    for(y in targetY+1 until N){
        for(x in targetX+1 until M) {
            dp[y][x] = dp[y-1][x] + dp[y][x-1]
        }
    }
    val hap2 = dp[N-1][M-1]
    println(hap1 * hap2)

}