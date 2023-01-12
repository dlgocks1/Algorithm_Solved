import java.io.*
import kotlin.system.exitProcess

private val reader = BufferedReader(InputStreamReader(System.`in`))
private lateinit var cities: Array<Int>

fun main() {
    val N = reader.readLine().toInt()
    val M = reader.readLine().toInt()
    cities = Array(N) { it }

    repeat(N) { now -> // 0부터 시작
        reader.readLine().split(" ").map { it.toInt() }.forEachIndexed { index, isLinked ->
            // now와 index가 연결되있음
            if (isLinked == 1) {
                union(now, index)
            }
        }
    }
//    println(cities.contentDeepToString())
    val plan = reader.readLine().split(" ").map { it.toInt() }
    for (i in 0 until plan.size - 1) {
        if (isJoin(plan[i] - 1, plan[i + 1] - 1) == false) {
            println("NO")
            return
        }
    }
    println("YES")
}

private fun find(now: Int): Int {
    if (now == cities[now]) return now
    val y = find(cities[now])
    cities[now] = y
    return y
}

private fun union(a: Int, b: Int) {

    val aParent = find(a)
    val bParent = find(b)
    if (aParent == bParent) return

    if (aParent > bParent) cities[bParent] = aParent
    else cities[aParent] = bParent
}

private fun isJoin(a: Int, b: Int): Boolean {
    return find(a) == find(b)
}