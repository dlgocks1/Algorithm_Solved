
import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var board: Array<MutableList<Int>>
private lateinit var distances: Array<MutableList<Int>>
private val dx = intArrayOf(0,0,1,-1)
private val dy = intArrayOf(1,-1,0,0)

fun main() {
    val (n,m) = reader.readLine().split(" ").map{ it.toInt() }
    board = Array(n) { mutableListOf<Int>() }
    distances = Array(n) { MutableList<Int>(m){ -1 } }

    repeat(n) {
        board[it] = reader.readLine().split(" ").map{ it.toInt() }.toMutableList()
    }

    val (targetX, targetY) =getTargetPosition(n, m, board)

    bfs(targetX, targetY,n,m)
}

private fun bfs(targetX: Int, targetY: Int,n:Int, m:Int) {
    val q= LinkedList<Triple<Int,Int,Int>>()
    val isvisited = Array(n){BooleanArray(m){false}}
    q.add(Triple(targetX,targetY,0))
    isvisited[targetY][targetX] = true

    while(q.isNotEmpty()){
        val (curX, curY,count) = q.pop()
        distances[curY][curX] = count
        for(i in 0 until 4) {
            val mx = curX + dx[i]
            val my = curY + dy[i]
            if(mx in 0 until m && my in 0 until n && !isvisited[my][mx] && board[my][mx] == 1) {
                isvisited[my][mx] = true
                q.add(Triple(mx, my,count+1))
            }
        }
    }
    board.forEachIndexed { rowidx, row ->
        row.forEachIndexed { colidx, col ->
            if(col == 0) distances[rowidx][colidx] = 0
        }
    }
    distances.forEach {
        println(it.joinToString(" "))
    }
}

private fun getTargetPosition(
    n: Int,
    m: Int,
    board: Array<MutableList<Int>>,
) : Pair<Int,Int> {
    var targetX = 0
    var targetY = 0
    for (y in 0 until n) {
        for (x in 0 until m) {
            if (board[y][x] == 2) {
                targetX = x
                targetY = y
                break
            }
        }
    }
    return targetX to targetY
}