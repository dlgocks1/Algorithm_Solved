class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        val countMap = mutableMapOf<Int,Int>()
        
        tangerine.forEach {
            countMap[it] = (countMap[it] ?: 0) + 1
        }
        var k = k
        countMap.toList().sortedBy { -it.second }.forEach {
            if(k <= 0) return@forEach
            k-= it.second
            answer += 1
        }
        
        return answer
    }
}