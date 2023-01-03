fun main() {

    val N = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }
    val dp = MutableList(N) { 1 }
    // 10 20 15 20 30 25 20
    // 10, 30, 10, 20, 20, 10
    //  1   1   2   1   1   2

    var mx = 1
    for (i in nums.indices) {
        for (j in 0..i) {
            if (nums[j] > nums[i]) {
                dp[i] = Math.max(dp[j] + 1, dp[i])
                mx = Math.max(mx, dp[i])
            }
        }
    }
    println(mx)
}