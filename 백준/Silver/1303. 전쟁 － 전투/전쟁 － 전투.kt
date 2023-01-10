
import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))
var WScore = 0
var BScore = 0
var count = 0

fun main() {
    val (N, M) = reader.readLine().split(" ").map { it.toInt() }
    val map = mutableListOf<String>()
    val visited = Array(M) { BooleanArray(N) { false } }

    repeat(M) {
        map.add(reader.readLine())
    }

    for (y in 0 until M) {
        for (x in 0 until N) {
            if (visited[y][x] == false) {
                dfs(y, x, map, visited, map[y][x])
                if (map[y][x] == 'W') {
                    WScore += count * count
                } else {
                    BScore += count * count
                }
                count = 0
            }
        }
    }
    println("$WScore $BScore")
}

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

private fun dfs(curY: Int, curX: Int, map: MutableList<String>, visited: Array<BooleanArray>, color: Char) {
    count++
    visited[curY][curX] = true
    for (i in 0 until 4) {
        val mx = curX + dx[i]
        val my = curY + dy[i]
        if (mx < 0 || my < 0 || my >= map.size || mx >= map.first().length) continue
        if (visited[my][mx] || map[my][mx] != color) continue
        dfs(my, mx, map, visited, color)
    }
}