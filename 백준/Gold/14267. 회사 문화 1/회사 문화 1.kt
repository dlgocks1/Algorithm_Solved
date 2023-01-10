import java.io.*
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))
val sc = java.util.Scanner(System.`in`)

fun main() {
    val n = sc.nextInt()
    val m = sc.nextInt()
    val delta = IntArray(n)
    val p = List(n) { sc.nextInt() - 1 }
    repeat(m) {
        val i = sc.nextInt()
        val w = sc.nextInt()
        delta[i - 1] = delta[i - 1] + w
    }
    for (i in 1 until n) if (p[i] < i) delta[i] = delta[i] + delta[p[i]]
    println(delta.joinToString(" "))
}
