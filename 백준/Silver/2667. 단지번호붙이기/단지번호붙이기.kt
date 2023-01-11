import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

private var counter = 0
fun main() {
    val N = reader.readLine().toInt()
    val apartment = Array<String>(N) { "" }
    repeat(N) {
        apartment[it] = reader.readLine()
    }

    val visited = Array(N) { BooleanArray(N) { false } }
    val answer = mutableListOf<Int>()
    for (y in 0 until N) {
        for (x in 0 until N) {
            if (visited[y][x] == false && apartment[y][x] == '1') {
                dfs(y, x, visited, apartment, N)
                answer.add(counter)
                counter = 0
            }
        }
    }
    println(answer.size)
    answer.sorted().forEach {
        println(it)
    }
}

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun dfs(y: Int, x: Int, visited: Array<BooleanArray>, apartment: Array<String>, size: Int) {
    counter++
    visited[y][x] = true

    for (i in 0 until 4) {
        val mx = x + dx[i]
        val my = y + dy[i]
        if (mx < 0 || my < 0 || mx >= size || my >= size) continue
        if (visited[my][mx] == true || apartment[my][mx] == '0') continue
        dfs(my, mx, visited, apartment, size)
    }
}