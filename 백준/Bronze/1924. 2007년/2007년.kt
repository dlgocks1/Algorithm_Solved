import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {

    val month = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val (x, y) = reader.readLine().split(" ").map { it.toInt() }
    var days = 0
    for (i in 1 until x) {
        days += month[i]
    }
    days += y
    val words = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
    println(words[days % 7])
}
