import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    repeat(reader.readLine().toInt()) {
        val (M, N, K) = reader.readLine().split(" ").map { it.toInt() }
        val board = Array(N) { IntArray(M) { 0 } }
        repeat(K) {
            val (X, Y) = reader.readLine().split(" ").map { it.toInt() }
            board[Y][X] = 1
        }
        val visited = Array(N) { BooleanArray(M) { false } }
        var count = 0
        for (y in 0 until N) {
            for (x in 0 until M) {
                if (board[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true
                    count++
                    dfs(x, y, board, visited, M, N)
                }
            }
        }
        println(count)
    }
}

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun dfs(x: Int, y: Int, board: Array<IntArray>, visited: Array<BooleanArray>, width: Int, height: Int) {
    for (i in 0 until 4) {
        val mx = dx[i] + x
        val my = dy[i] + y
        if (mx < 0 || mx >= width || my < 0 || my >= height) continue
        if (board[my][mx] == 0 || visited[my][mx]) continue

        visited[my][mx] = true
        dfs(mx, my, board, visited, width, height)

    }
}