fun main() {
    val N = readLine()!!.toInt()
    val M = readLine()!!.toInt()
    val broken: List<String> = if (M != 0) {
        readLine()!!.split(" ").map { it }
    } else {
        emptyList()
    }

    var answer = Math.abs(100 - N)

    for (num in 0..1_000_000) {
        var passed = true
        for (i in num.toString()) {
            if (broken.contains(i.toString())) {
                passed = false
                break
            }
        }
        if (passed) answer = Math.min(answer, num.toString().length + Math.abs(num - N))
    }
    println(answer)

}