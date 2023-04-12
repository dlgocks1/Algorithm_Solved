class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        
        // fees : 기본시간, 기본요금, 단위시간, 단위요금
        // records : "05:35 0000 IN"
        
        // 1. 각차량별 시간 계산
        val timeTables = mutableMapOf<String,Int>()
        records.forEach { record->
            val table = record.split(" ")
            val time = table[0].split(":").let {
                it[0].toInt() * 60 + it[1].toInt()
            }
            val identifier = table[1]
            val history = table[2]
            
            if(history == "IN") {
                timeTables[identifier] = (timeTables[identifier] ?: 0) + time 
            } else {
                timeTables[identifier] = timeTables[identifier]!! - time 
            }
        }
        
        val timeLogs = timeTables.map {
            var time = it.value
            if(time >= 0) {
                time -= (23 * 60 + 59)
            }
            it.key to -time
        }
        
        val baseTime = fees[0]
        val baseFee = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]
        
        // 2. 차랑별 요금 계산 
        val feeTables = timeLogs.map {
            val time = it.second
            var fee = baseFee
            if(time > baseTime) {
                fee = fee + Math.ceil(((time - baseTime) / unitTime.toDouble())).toInt() * unitFee
            }
            it.first to fee
        }
        
        var answer: IntArray = intArrayOf()
        feeTables.sortedBy { it.first }.forEach {
            answer += it.second
        }
        
        return answer
    }
}