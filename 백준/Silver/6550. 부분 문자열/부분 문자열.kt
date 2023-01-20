
import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    while (true) {
        try {
            val (s, t) = reader.readLine().split(" ")
            var index = 0
            for (i in t.indices) {
                if (t[i] == s[index]) {
                    index++
                    if (s.length == index) break
                }
            }
            if (s.length == index) {
                println("Yes")
            } else {
                println("No")
            }
        } catch (e: Exception) {
            break
        }
    }
}