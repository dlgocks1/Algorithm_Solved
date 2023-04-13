class Solution {
    fun solution(n: Int, times: IntArray): Long {

        val maxTime = (times.maxOrNull() ?: 0).toLong()
        var right: Long = maxTime * n
        var left: Long = 0
        
        while(left <= right) {
            var mid = (right + left) / 2
            var count:Long = 0
            for(time in times) {
                count += mid / time
            }
            // println("측정 시간 : $mid 카운트 : $count")
            
            if(count >= n) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        
        
        return right + 1
    }
}