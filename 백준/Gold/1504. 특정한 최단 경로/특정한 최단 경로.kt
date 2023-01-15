import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var board: Array<MutableList<Pair<Int, Int>>>

fun main() {
    val (N, E) = reader.readLine().split(" ").map { it.toInt() }
    board = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(E) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
        board[a].add(b to c)
        board[b].add(a to c)
    }
    val (v1, v2) = reader.readLine().split(" ").map { it.toInt() }

    // 1번에서 N번으로
    val path1 = listOf(1, v1, v2, N)
    val path2 = listOf(1, v2, v1, N)
    var answer = Math.min(
        getDistance(path1, N),
        getDistance(path2, N),
    )
    if (answer == -1) {
        println(-1)
    } else {
        println(answer)
    }
}

private fun getDistance(path: List<Int>, N: Int): Int {
    var answer = 0
    for (i in 0 until path.size - 1) {
        val distance = dijkstra(path[i], path[i + 1], N)
        if (distance == Int.MAX_VALUE) return -1
        answer += distance
    }
    return answer
}

private fun dijkstra(start: Int, end: Int, N: Int): Int {
    val cost = Array(N + 1) { Int.MAX_VALUE }
    cost[start] = 0
    val q = LinkedList<Int>()
    q.add(start)

    while (q.isNotEmpty()) {
        val now = q.pop()
        board[now].forEach { (mx, costs) ->
            if (cost[now] + costs < cost[mx]) {
                cost[mx] = cost[now] + costs
                q.add(mx)
            }
        }
    }
    return cost[end]
}