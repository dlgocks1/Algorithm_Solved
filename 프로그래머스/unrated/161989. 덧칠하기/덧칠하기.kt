class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        
        var start = 0
        section.forEach {
            if(it > start) {
                start = it + m -1 
                answer +=1
            }
        }
        
        return answer
    }
}