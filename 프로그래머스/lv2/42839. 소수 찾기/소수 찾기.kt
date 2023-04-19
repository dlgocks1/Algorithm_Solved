import java.util.*

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        val visited = BooleanArray(numbers.length) { false }
        val sosu = getSosuList()
        val stack = Stack<Int>()
        val results = mutableSetOf<Int>()
        
        fun dfs() {
            if(stack.isNotEmpty()) results.add(stack.joinToString("").toInt())
            if(stack.size == numbers.length) return 
            
            for(i in 0 until numbers.length) {
                val now = numbers[i]
                if(!visited[i]) {
                    visited[i] = true
                    stack.add(now - '0')
                    dfs()
                    visited[i] = false
                    stack.pop()
                }
            }
        }
        
        dfs()
        
        return results.filter { sosu[it] }.count()
    }
    
    fun getSosuList() : BooleanArray {
        val numbers = BooleanArray(10_000_000) { true }
        numbers[0] = false
        numbers[1] = false
        for(i in 2 until 1_000_001) {
            if(!numbers[i]) continue
            var j = i*2
            while(j < numbers.size){
                numbers[j] = false
                j+=i
            }
        }
        
        return numbers
    }
    
}