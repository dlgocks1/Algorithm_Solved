import java.util.*


fun main() {
    val stringBuilder = StringBuilder()
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
//    val arr = List<Int>(N) { it + 1 }
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    dfs(0, arr, Stack<Int>(), M, stringBuilder)
    println(stringBuilder.toString())
}

private fun dfs(idx: Int, arr: List<Int>, stack: Stack<Int>, size: Int, stringBuilder: StringBuilder) {
    if (stack.size == size) {
        stack.forEach {
            stringBuilder.append("$it ")
        }
        stringBuilder.append('\n')
        return
    }

    for (i in arr.indices) {
        stack.push(arr[i])
        dfs(i, arr, stack, size, stringBuilder)
        stack.pop()
    }
}

