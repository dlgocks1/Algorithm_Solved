class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        var start = 0
        var end = 0
        
        targets
            .sortedBy{ it[0] }
            .sortedBy{ it[1] }
            .forEach {
                // if(end < it[1]) {
                    // end = it[1]
                // }
                if(end <= it[0]) {
                    end = it[1]
                    answer += 1
                }
                
            }
        
        return answer
    }
}