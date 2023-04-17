import java.util.*

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = ArrayList<Int>()
        val costs = costs.toList().sortedBy { it[2] }
        val cycle = Array<Int>(n) { it }
        
        fun find(x: Int): Int {
            if(cycle[x] == x) return x
            return find(cycle[x])
        }
        
        fun union(x: Int, y: Int) {
            if(x > y) cycle[find(x)] = find(y)
            else cycle[find(y)] = find(x)
        }
        
        costs.forEach {

            if(find(cycle[it[0]]) != find(cycle[it[1]])){
                union(it[0], it[1])
                answer.add(it[2])
                // println(cycle.contentToString())
                // println(answer.toString())
                if(answer.size == n-1) {
                    return answer.sum()
                }
            }
        }
        
        return -1
    }
    
    
    
}