import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun main() {
    var problemNum = 1
    while (true) {
        val N = reader.readLine().toInt()
        if (N == 0) break
        val cost = Array(N) { IntArray(N) { Int.MAX_VALUE } }
        val blackRufee = Array(N) { mutableListOf<Int>() }
        repeat(N) {
            blackRufee[it] = reader.readLine().split(" ").map { it.toInt() }.toMutableList()
        }
        val q = LinkedList<Pair<Int, Int>>()
        cost[0][0] = blackRufee[0][0]
        q.add(0 to 0)
        while (q.isNotEmpty()) {
            val (curY, curX) = q.pop()
            for (i in 0 until 4) {
                val my = curY + dy[i]
                val mx = curX + dx[i]
                if (mx !in 0 until N || my !in 0 until N) continue
                if (cost[curY][curX] + blackRufee[my][mx] < cost[my][mx]) {
                    cost[my][mx] = cost[curY][curX] + blackRufee[my][mx]
                    q.add(my to mx)
                }
            }
        }
        println("Problem $problemNum: ${cost[N - 1][N - 1]}")
        problemNum++
    }

}