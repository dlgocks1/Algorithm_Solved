import java.io.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val N = reader.readLine().toInt()
    val cards = reader.readLine().split(" ").map { it.toInt() }.sorted()
    val M = reader.readLine().toInt()
    val finds = reader.readLine().split(" ").map { it.toInt() }

    finds.forEach { find ->
        print("${binarySearch(cards, find)} ")
    }

}

private fun binarySearch(cards: List<Int>, find: Int): Int {
    var left = 0
    var right = cards.size
    var mid: Int
    while (left <= right) {
        mid = (left + right) / 2
        if (mid >= cards.size) break
        if (cards[mid] == find) return 1
        if (find > cards[mid]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return 0
}