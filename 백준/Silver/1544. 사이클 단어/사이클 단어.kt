fun main() {
    val N = readLine()!!.toInt()
    val arr = mutableListOf<String>()
    val table = IntArray(N) { it }
    repeat(N) {
        arr.add(readLine()!!)
    }
    for(i in arr.indices) {
        for(j in i+1 until arr.size) {
            if(arr[i].length != arr[j].length || table[i] == table[j]) continue
            var nowWord = arr[i].toCharArray().toMutableList()
            for(x in 0 .. nowWord.size * 2) {
                if(nowWord.joinToString("") == arr[j]) {
                    table[i] = i
                    table[j] = i
                    break
                }
                val first = nowWord.removeFirst()
                nowWord.add(first)
            }
        }
    }
    println(table.toSet().size)
}
