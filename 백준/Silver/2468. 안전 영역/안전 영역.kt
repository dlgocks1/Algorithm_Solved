
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val N = reader.readLine().toInt()
    val location = mutableListOf<List<Int>>()
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)

    repeat(N) {
        location.add(reader.readLine().split(" ").map { it.toInt() })
    }
    var isvisited = MutableList(N) { MutableList(N) { false } }
    val q = LinkedList<Pair<Int, Int>>()
    var answer = 0
    var count = 0
    for (height in 1..100) {
        isvisited = MutableList(N) { MutableList(N) { false } }
        answer = Math.max(answer, count)
        count = 0
        for (y in 0 until N) {
            for (x in 0 until N) {
                if (isvisited[y][x] || location[y][x] <= height) continue
                isvisited[y][x] = true
                count++
                q.add(y to x)
                while (q.isNotEmpty()) {
                    val (cury, curx) = q.pop()
                    for (j in dy) {
                        val my = cury + j
                        val mx = curx
                        if (my in 0 until N && mx in 0 until N) {
                            if (isvisited[my][mx] == false && location[my][mx] > height) {
                                isvisited[my][mx] = true
                                q.add(my to mx)
                            }
                        }
                    }
                    for (i in dx) {
                        val my = cury
                        val mx = curx + i
                        if (my in 0 until N && mx in 0 until N) {
                            if (isvisited[my][mx] == false && location[my][mx] > height) {
                                isvisited[my][mx] = true
                                q.add(my to mx)
                            }
                        }
                    }
                }
            }
        }

    }
    if (answer == 0) {
        println(1)
    } else {

        println(answer)
    }

}

