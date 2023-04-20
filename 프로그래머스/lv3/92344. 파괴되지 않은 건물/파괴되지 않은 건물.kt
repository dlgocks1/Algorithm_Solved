class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        
        val building = board.map { it.toMutableList() }
        val sumTable = Array<IntArray>(building.size + 1) { 
            IntArray(building[0].size + 1) { 0 } 
        }
        
        skill.forEach {
            val type = it[0]
            val r1 = it[1]
            val c1 = it[2]
            val r2 = it[3]
            val c2 = it[4]
            val degree = it[5]
            
            if(type == 1) {
                sumTable[r1][c1] -= degree
                sumTable[r1][c2+1] += degree
                sumTable[r2+1][c1] += degree
                sumTable[r2+1][c2+1] -= degree
            } else {
                sumTable[r1][c1] += degree
                sumTable[r1][c2+1] -= degree
                sumTable[r2+1][c1] -= degree
                sumTable[r2+1][c2+1] += degree
            }
        }
        
        for(y in 0 until sumTable.size) {
            for(x in 1 until sumTable[0].size) {
                sumTable[y][x] += sumTable[y][x-1]
            }
        }
        
        for(x in 0 until sumTable[0].size) {
            for(y in 1 until sumTable.size) {
                sumTable[y][x] += sumTable[y-1][x]
            }
        }
        
        for(y in building.indices) {
            for(x in building[0].indices) {
                building[y][x] += sumTable[y][x]
                answer += if(building[y][x] > 0) 1 else 0
            }
        }
        
        return answer
    }
}