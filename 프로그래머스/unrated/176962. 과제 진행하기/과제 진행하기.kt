import java.util.*

class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val plans = plans.sortedBy { it[1] }
        // ["science", "12:40", "50"]
        val stack = Stack<Pair<String,Int>>() // 일 수, 남은 시간
        var lastTime = 0
        plans.forEach {
            val currentTime = getTime(it[1])
            var remainTime = getTime(it[1]) - lastTime
            while(stack.isNotEmpty() && remainTime > 0) {
                val lastWork = stack.pop()
                if(lastWork.second <= remainTime) {
                    remainTime -= lastWork.second
                    answer += lastWork.first
                } else {
                    stack.add(lastWork.first to lastWork.second - remainTime)
                    break
                }
            }
            
            stack.add(it[0] to it[2].toInt())
            
            lastTime = currentTime
        }
        
        while(stack.isNotEmpty()) {
            answer += stack.last().first
            stack.pop()
        }
        
        return answer
    }
    
    fun getTime(time: String): Int {
        val splited = time.split(":")
        return splited[0].toInt() * 60 + splited[1].toInt() 
    }
}