class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0
        score.sortedDescending().chunked(m).forEach{
            if(it.size < m) return@forEach
            answer += it.last() * m
        }
        return answer
    }
}