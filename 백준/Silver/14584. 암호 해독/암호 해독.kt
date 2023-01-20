import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val pswd = reader.readLine()
    val N = reader.readLine().toInt()
    val words = mutableListOf<String>()
    repeat(N) {
        words.add(reader.readLine())
    }
    for (i in 0..25) {
        val stringBuilder = StringBuilder()
        pswd.forEach {
            val nextChar = it + i
            if (nextChar > 'z') {
                stringBuilder.append(nextChar - 26)
            } else {
                stringBuilder.append(it + i)
            }
        }
        val decryption = stringBuilder.toString()
        if (words.any { decryption.contains(it) }) {
            println(decryption)
            return
        }
    }
}