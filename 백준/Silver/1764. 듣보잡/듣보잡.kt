

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val hashMap = hashMapOf<String,Int>()
    repeat(N+M) {
        val name = readLine()!!
        if(hashMap[name] == null) hashMap[name] = 1
        else hashMap[name] = hashMap[name]!! + 1
    }
    hashMap.toList().filter {it.second >=2 }.sortedBy { it.first }.let {
        println(it.size)
        it.forEach {
            println(it.first)
        }
    }
}
