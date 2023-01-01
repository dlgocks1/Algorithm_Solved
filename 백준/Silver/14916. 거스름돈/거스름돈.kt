fun main() {
    val charge = readLine()!!.toInt()
    val dp = mutableListOf<Int>()
    dp.add(-1) // 0
    dp.add(-1) // 1
    dp.add(1) // 2
    dp.add(-1) // 3
    dp.add(2) // 4
    dp.add(1) // 5
    dp.add(3) // 6
    dp.add(2) // 7
    dp.add(4) // 8
    dp.add(3) // 9

    for (i in 10..charge + 1) {
        dp.add(Math.min(dp[i - 2] + 1, dp[i - 5] + 1))
    }
    println(dp[charge])
}