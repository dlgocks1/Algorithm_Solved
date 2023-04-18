import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        var q = LinkedList<Char>(s.toCharArray().toList())
        var idx = 0
        while(idx < s.length) {
            
            val result = Stack<Char>()
            var flag = true
            q.toList().forEach {
                when(it) {
                    ']' -> {
                        if(result.lastOrNull() ?: ' ' == '[') {
                            result.pop()
                        } else {
                            flag = false
                        }
                    }
                    '}' -> {
                        if(result.lastOrNull() ?: ' ' == '{') {
                            result.pop()
                        }else {
                            flag = false
                        }
                    }
                    ')' -> {
                        if(result.lastOrNull() ?: ' ' == '(') {
                            result.pop()
                        }else {
                            flag = false
                        }
                    } 
                    else ->{
                        result.add(it)
                    }
                }
                // println(result)
            }
            
            // [{]}  []
            // println(q)
            if(result.isEmpty() && flag) answer++
            q.add(q.pop())
            idx++
        }
        
        return answer
    }
}