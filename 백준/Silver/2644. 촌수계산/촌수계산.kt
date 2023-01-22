import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val (p1, p2) = reader.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(reader.readLine().toInt()) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }

    val q = LinkedList<Pair<Int, Int>>()
    val isvisited = BooleanArray(n + 1) { false }
    q.add(p1 to 0)
    while (q.isNotEmpty()) {
        val (now, cnt) = q.pop()
        if (now == p2) {
            println(cnt)
            return
        }
        isvisited[now] = true
        for (next in graph[now]) {
            if (isvisited[next] == false) {
                q.add(next to cnt + 1)
            }
        }
    }
    println(-1)


}

