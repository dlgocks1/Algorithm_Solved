import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

lateinit var nums: Array<Int>

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    nums = Array(n + 1) { it }
//    println(nums.contentDeepToString())
    repeat(m) {
        val (x, a, b) = reader.readLine().split(" ").map { it.toInt() }
        if (x == 0) {
            union(a, b)
        } else {
            if (isUnion(a, b)) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
//    println(nums.contentDeepToString())
}

private fun find(now: Int): Int {
    if (now == nums[now]) return now
    else {
        val y = find(nums[now])
        nums[now] = y
        return y
    }
//    return find(nums[now])
}

private fun union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)
    if (aParent == bParent) return
    if (aParent < bParent) nums[bParent] = aParent
    else nums[aParent] = bParent
}

private fun isUnion(a: Int, b: Int): Boolean {
    return find(a) == find(b)
}
