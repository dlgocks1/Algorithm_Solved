class Solution {
    fun solution(s: String): IntArray {
         var answer: IntArray = IntArray(s.length) { -1 }
        s.forEachIndexed { idx, c ->
            if(s.substring(0,idx).indexOfLast { it==c } != -1){
                answer[idx] = idx - s.substring(0,idx).indexOfLast { it==c                  }
            }
        }
        return answer
    }
}