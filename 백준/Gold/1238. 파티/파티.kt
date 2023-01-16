import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

private lateinit var load: Array<MutableList<Pair<Int, Int>>>

fun main() {

    val (N, M, X) = reader.readLine().split(" ").map { it.toInt() }
    load = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(M) {
        val (start, end, time) = reader.readLine().split(" ").map { it.toInt() }
        load[start].add(end to time)
    }
    var answer = 0
    for (start in 1..N) {
        if (start == X) continue
        answer = Math.max(answer, dijkstra(start, X, N) + dijkstra(X, start, N))
    }
    println(answer)
}

private fun dijkstra(start: Int, destination: Int, nodeSize: Int): Int {
    val distance = (0..nodeSize).map { Int.MAX_VALUE }.toMutableList()

    val q = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
        when {
            p1.second > p2.second -> 1
            p1.second < p2.second -> -1
            else -> 0
        }
    }
    q.add(start to 0)
    distance[start] = 0
    while (q.isNotEmpty()) {
        val (now, dist) = q.poll()
        if (distance[now] < dist) continue
        for (direction in load[now]) {
            val distSum = dist + direction.second
            if (distSum < distance[direction.first]) {
                distance[direction.first] = distSum
                q.add(direction.first to distSum)
            }
        }
    }
    return distance[destination]
}