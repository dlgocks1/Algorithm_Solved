class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        
        var storey = storey
        
        while(storey > 0) {
            val last = storey % 10
            when(last) {
                in 0..4 -> {
                    answer += last
                }
                in 6..9 -> {
                    storey += 10
                    answer += (10 - last)
                }
                5 -> {
                    if( storey / 10 % 10 > 4 ) {
                        storey += 10
                    }
                    answer += last
                }
            }
            storey /= 10
        }
        
        return answer
    }
  
}