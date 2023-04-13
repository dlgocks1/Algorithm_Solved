class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        
        val pq = mutableListOf<Int>()
        
        operations.forEach {
            val command = it.split(" ")
            val operation = command[0]
            val number = command[1].toInt()
            
            when(operation) {
                "I" -> {
                    pq.add(number)
                }
                "D" -> {
                    if(number == 1) {
                        pq.maxOrNull()?.let { pq.remove(it) }
                    } else {
                        pq.minOrNull()?.let { pq.remove(it) }
                    }
                }
            }
        }
       
        answer +=  pq.maxOrNull() ?: 0
        answer +=  pq.minOrNull() ?: 0
        
        return answer
    }
}