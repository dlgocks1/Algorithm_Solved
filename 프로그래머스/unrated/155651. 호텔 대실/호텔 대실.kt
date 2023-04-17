class Solution {
    
    val dayTime = 24 * 60 + 10
    
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        val timeTable = Array(dayTime) { 0 }
        
        book_time.forEach {
            val startTime = toMinute(it[0])
            val endTime = toMinute(it[1])
            timeTable[startTime] += 1
            timeTable[endTime + 10] -= 1
        }
        for(i in 1 until timeTable.size) {
            timeTable[i] += timeTable[i-1] 
            answer = Math.max(timeTable[i], answer)
        }
        
        return answer
    }
    
    fun toMinute(time:String):Int {
        val time = time.split(":")
        val hour = time[0].toInt() * 60
        val minute = time[1].toInt()
        return hour + minute 
    }
}