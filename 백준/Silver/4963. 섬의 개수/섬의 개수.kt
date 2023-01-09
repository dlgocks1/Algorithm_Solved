import java.io.*
import java.util.*
import kotlin.random.Random.Default.nextInt

private val reader = BufferedReader(InputStreamReader(System.`in`))
lateinit var board: Array<IntArray>
lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(1, 0, -1, 0, 1, 1, -1, -1)
private val dy = intArrayOf(0, 1, 0, -1, 1, -1, 1, -1)

fun main() {
    while (true) {
        val (w, h) = reader.readLine().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break
        board = Array(h) { IntArray(w) }
        visited = Array(h) { BooleanArray(w) }
        repeat(h) {
            board[it] = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        var answer = 0
        for (y in 0 until h) {
            for (x in 0 until w) {
                if (board[y][x] == 1 && !visited[y][x]) {
                    answer++
                    dfs(y, x, w, h)
                }
            }
        }
        println(answer)
    }
}

private fun dfs(y: Int, x: Int, w: Int, h: Int) {
    visited[y][x] = true
    for (dir in 0 until 8) {
        val mx = dx[dir] + x
        val my = dy[dir] + y
        if (my >= h || mx < 0 || mx >= w || my < 0) continue
        if (visited[my][mx] || board[my][mx] == 0) continue
        dfs(my, mx, w, h)
    }
}