class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        
        val dp = LongArray(2002) { 0L }
        dp[0] = 0L
        dp[1] = 1L
        dp[2] = 2L
        for(i in 3..n){
            dp[i] = (dp[i-1]+dp[i-2]) % 1234567
        }
        
//         fun dfs(now:Int) {
//             if(now == n) answer = (answer +1) % 1234567
            
//             for(i in 1..2){
//                 if(now+i<=n){
//                     dfs(now+i)
//                 }
//             }
//         }
        
//         dfs(0)
//         println(answer)
        
        return dp[n]
    }
}