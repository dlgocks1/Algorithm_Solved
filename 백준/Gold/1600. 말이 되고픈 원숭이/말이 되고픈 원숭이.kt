import java.io.*
import java.util.*

data class Point(var x: Int, var y: Int, var d: Int, var k: Int)

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val dx = intArrayOf(1, -1, 0, 0) // 4 방향
    val dy = intArrayOf(0, 0, 1, -1)
    val horseDx = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2) // 8방향
    val horseDy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

    val K = reader.readLine().toInt()
    val (W, H) = reader.readLine().split(" ").map { it.toInt() }
    val board = Array(H) { Array(W) { 0 } }

    val q: Queue<Point> = LinkedList()
    val isvisited = Array(H) { Array(W) { Array(K + 1) { false } } }

    repeat(H) { y ->
        val st = StringTokenizer(reader.readLine(), " ")
        repeat(W) { x -> board[y][x] = st.nextToken().toInt() }
    }

    q.offer(Point(0, 0, 0, 0))
    isvisited[0][0][0] = true
    while (q.isNotEmpty()) {
        val target = q.poll()
        val tx = target.x
        val ty = target.y
        val tk = target.k
        val td = target.d

        if (tx == H - 1 && ty == W - 1) {
            println(td)
            return
        }

        for (i in 0 until 4) {
            val nx = tx + dx[i]
            val ny = ty + dy[i]

            if (nx !in 0 until H || ny !in 0 until W || isvisited[nx][ny][tk] || board[nx][ny] == 1) continue
            q.offer(Point(nx, ny, td + 1, tk))
            isvisited[nx][ny][tk] = true
        }

        // knight 처럼 움직임
        if (tk < K) {
            for (i in 0 until 8) {
                val nx = tx + horseDx[i]
                val ny = ty + horseDy[i]
                val nk = tk + 1

                if (nx !in 0 until H || ny !in 0 until W || isvisited[nx][ny][nk] || board[nx][ny] == 1) continue
                q.offer(Point(nx, ny, td + 1, nk))
                isvisited[nx][ny][nk] = true
            }
        }

    }

    println(-1)
}