class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        val size: Int = p.length
        for(idx in 0..t.length-size) {
            val num = t.substring(idx,idx+size).toLong()
            if(num <= p.toLong()) answer +=1
        }
        
        return answer
    }
}