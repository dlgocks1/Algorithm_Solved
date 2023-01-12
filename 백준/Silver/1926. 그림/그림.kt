import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))
private var counter = 0

// dfs
fun main() {

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val board = mutableListOf<List<Int>>()
    repeat(n) {
        board.add(reader.readLine().split(" ").map { it.toInt() })
    }
    val isvisited = Array(n) { BooleanArray(m) { false } }
    val answer = mutableListOf<Int>()
    for (y in 0 until n) {
        for (x in 0 until m) {
            counter = 0
            if (isvisited[y][x] == false && board[y][x] == 1) {
                dfs(y, x, board, isvisited, n, m)
                answer.add(counter)
            }
        }
    }
    println(answer.size)
    if (answer.isEmpty()) {
        println(0)
    } else {
        println(answer.max())
    }
}

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

private fun dfs(y: Int, x: Int, board: List<List<Int>>, isvisited: Array<BooleanArray>, n: Int, m: Int) {
    counter++
    isvisited[y][x] = true

    for (i in 0 until 4) {
        val my = y + dy[i]
        val mx = x + dx[i]
        if (my !in 0 until n || mx !in 0 until m) continue
        if (isvisited[my][mx] || board[my][mx] == 0) continue
        dfs(my, mx, board, isvisited, n, m)
    }
}