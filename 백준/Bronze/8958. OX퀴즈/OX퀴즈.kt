import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val N = reader.readLine().toInt()
    var answer = 0
    var count = 1
    repeat(N) {
        val quiz = reader.readLine()
        quiz.forEach {
            if (it == 'O') {
                answer += count
                count++
            } else {
                count = 1
            }
        }
        println(answer)
        answer = 0
        count = 1
    }

}