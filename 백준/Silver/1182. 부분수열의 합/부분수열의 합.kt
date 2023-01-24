import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

private lateinit var nums: List<Int>
private var ans: Int = 0

fun main() {
    val (N, S) = reader.readLine().split(" ").map { it.toInt() }

    nums = reader.readLine().split(" ").map { it.toInt() }
    val isvisited = BooleanArray(N) { false }

    val stack = Stack<Int>()
    dfs(0, S, isvisited, stack)

    println(ans)
}

private fun dfs(curPos: Int, target: Int, isvisited: BooleanArray, stack: Stack<Int>) {
    if (target == stack.sum() && stack.isNotEmpty()) {
        ans++
    }
    for (idx in curPos until nums.size) {
        if (!isvisited[idx]) {
            isvisited[idx] = true
            stack.add(nums[idx])
            dfs(idx, target, isvisited, stack)
            stack.pop()
            isvisited[idx] = false
        }
    }
}