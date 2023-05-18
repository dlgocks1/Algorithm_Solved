
fun main() {
    val N = readLine()!!.toInt()
    val map = mutableMapOf<String, Int>()
    repeat(N) {
        val book = readLine()!!
        if(map[book] == null) map[book] = 1
        else map[book] = map[book]!! + 1
    }
    map.toList().sortedBy { it.first }.sortedBy { -it.second }.let{
        println(it.first().first)
    }
}
