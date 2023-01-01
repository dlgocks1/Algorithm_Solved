fun main() {
    val T = readLine()!!.toInt()
    repeat(T) {
        val N = readLine()!!.toInt()
        val dots = readLine()!!.split(" ").map { it.toInt() }.sorted()

        var answer = 0
        for (first in dots.indices) {
            for (last in first + 2 until dots.size) {
                if (binarySearch(dots, first, last)) answer++
            }
        }
        println(answer)
    }
}

private fun binarySearch(dots: List<Int>, first: Int, last: Int): Boolean {
    if ((Math.abs(dots[first] + dots[last]) % 2) == 1) return false
    val target = (dots[first] + dots[last]) / 2
    var left = first
    var right = last
    var mid = (left + right) / 2
    while (left <= right) {
        if (dots[mid] == target) {
            return true
        } else if (target < dots[mid]) {
            right = mid - 1
        } else {
            left = mid + 1
        }
        mid = (left + right) / 2
    }
    return false
}
