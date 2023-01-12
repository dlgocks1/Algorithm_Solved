import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

private var counter = 0

fun main() {
    val (N, M, K) = reader.readLine().split(" ").map { it.toInt() }
    val board = Array(M) { Array(N) { '.' } }
    repeat(K) {
        val (r, c) = reader.readLine().split(" ").map { it.toInt() }
        board[c - 1][r - 1] = '#'
    }
    var answer = Int.MIN_VALUE
    val isvisited = Array(M) { BooleanArray(N) { false } }
    for (y in 0 until M) {
        for (x in 0 until N) {
            counter = 0
            if (isvisited[y][x] == false && board[y][x] == '#') {
                dfs(y, x, board, isvisited, M, N)
                answer = Math.max(answer, counter)
            }
        }
    }
    println(answer)
}

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

private fun dfs(y: Int, x: Int, board: Array<Array<Char>>, isvisited: Array<BooleanArray>, M: Int, N: Int) {
    counter++
    isvisited[y][x] = true

    for (i in 0 until 4) {
        val my = y + dy[i]
        val mx = x + dx[i]
        if (my !in 0 until M || mx !in 0 until N) continue
        if (isvisited[my][mx] || board[my][mx] == '.') continue
        dfs(my, mx, board, isvisited, M, N)
    }

}