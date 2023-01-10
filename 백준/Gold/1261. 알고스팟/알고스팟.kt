import java.io.*
import java.util.*
private val reader = BufferedReader(InputStreamReader(System.`in`))

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun main() {
    val (M, N) = reader.readLine().split(" ").map { it.toInt() }
    val map = mutableListOf<String>()
    repeat(N) {
        map.add(reader.readLine())
    }
    val scoreBoard = Array(N) { IntArray(M) { Int.MAX_VALUE } }
    val q = LinkedList<Pair<Int, Int>>()
    q.add(0 to 0)
    scoreBoard[0][0] = 0
    while (q.isNotEmpty()) {
        val (curY, curX) = q.pop()
        for (i in 0 until 4) {
            val mx = curX + dx[i]
            val my = curY + dy[i]
            if (mx < 0 || mx >= M || my < 0 || my >= N) continue
            if (map[my][mx] == '1') {
                if (scoreBoard[curY][curX] + 1 < scoreBoard[my][mx]) {
                    scoreBoard[my][mx] = Math.min(scoreBoard[curY][curX] + 1, scoreBoard[my][mx])
                    q.add(my to mx)
                }
            } else {
                if (scoreBoard[curY][curX] < scoreBoard[my][mx]) {
                    scoreBoard[my][mx] = Math.min(scoreBoard[curY][curX], scoreBoard[my][mx])
                    q.add(my to mx)
                }
            }
        }
    }
    println(scoreBoard[N - 1][M - 1])
}