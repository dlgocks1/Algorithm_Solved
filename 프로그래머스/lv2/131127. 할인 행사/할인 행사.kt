class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        
        val buys = want.mapIndexed { idx, item -> 
            item to number[idx]
        }
        
        for(i in 0..discount.size - 10) {
            val discountMap = mutableMapOf<String,Int>()
            for(j in i until i + 10) {
                if(discountMap[discount[j]] == null ) {
                    discountMap[discount[j]] = 1
                } else {
                    discountMap[discount[j]] = discountMap[discount[j]]!! + 1
                }
            }
            
            if (buys.all { 
                (discountMap[it.first] ?: 0 ) >= it.second
            }) {
                answer +=1
            }
        }
        
        return answer
    }
}