import java.util.*
val stringBuilder = StringBuilder()
fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val arr = List<Int>(N) { it + 1 }
    dfs(0, arr, Stack<Int>(), M)
    println(stringBuilder.toString())
}

private fun dfs(idx: Int, arr: List<Int>, stack: Stack<Int>, size: Int) {
    if (stack.size == size) {
        stack.forEach {
            stringBuilder.append("$it ")
        }
        stringBuilder.append('\n')
        return
    }

    for (i in arr.indices) {
        stack.push(arr[i])
        dfs(i + 1, arr, stack, size)
        stack.pop()
    }
}