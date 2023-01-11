
import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (N, K) = reader.readLine().split(" ").map { it.toInt() }
    val distance = IntArray(100_005) { 0 }
    val q = LinkedList<Pair<Int, Int>>()
    q.add(N to 0)
    while (q.isNotEmpty()) {
        val (now, count) = q.pop()
        distance[now] = count
        if (now == K) {
            println(count)
            break
        }
        if (now + 1 < 100_001 && distance[now + 1] == 0) {
            q.add(now + 1 to count + 1)
        }
        if (now - 1 >= 0 && distance[now - 1] == 0) {
            q.add(now - 1 to count + 1)
        }
        if (now * 2 >= 0 && now * 2 < 100_001 && distance[now * 2] == 0) {
            q.add(now * 2 to count + 1)
        }
    }
}