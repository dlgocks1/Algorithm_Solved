class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var cycle =0
        var count = 0
        var s = s
        while(s != "1") {
            count += s.count { it == '0'} 
            s = s.replace("0","").length.toString(2)
            cycle+=1
        }
        answer += cycle
        answer += count
        return answer
    }
}