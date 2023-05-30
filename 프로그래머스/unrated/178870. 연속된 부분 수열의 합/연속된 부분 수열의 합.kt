class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: ArrayList<Pair<Int,Int>> = arrayListOf()
        var left = 0
        var right = -1
        var sum = 0
        
        while(true) {
            if(sum <= k) {
                right += 1
                if(right >= sequence.size) break
                sum += sequence[right]
            } else {
                sum -= sequence[left]
                left += 1
                if(left >= sequence.size) break
            }
            if(sum == k) {
                answer.add(left to right)
            }
        }
        
        return answer.sortedBy { it.first }.sortedBy { it.second - it.first }.first().toList().toTypedArray().toIntArray()
    }
}