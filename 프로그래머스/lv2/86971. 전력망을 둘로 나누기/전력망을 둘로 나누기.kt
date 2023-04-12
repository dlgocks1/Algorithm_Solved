import java.util.*

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        
        for(removeIdx in 0 until n - 1) {
            val routes = List<MutableList<Int>>(n+1) { mutableListOf<Int>() }
            wires.forEachIndexed { idx, wire->
                if(idx == removeIdx) return@forEachIndexed
                routes[wire[0]].add(wire[1])
                routes[wire[1]].add(wire[0])
            }  
            answer = Math.min(
                Math.abs(dfs(routes, wires[removeIdx][0], n) - dfs(routes, wires[removeIdx][1], n))
                ,answer
            )
        }
        
        return answer
    }
    
    fun dfs(routes: List<MutableList<Int>>, now: Int, n: Int): Int {
        
        val q = LinkedList<Int>()
        val visited = BooleanArray(n+1) { false } 
        q.add(now)
        visited[now] = true
        var cnt = 1
        while(q.isNotEmpty()) {
            val now = q.poll()
            for(i in routes[now]) {
                if(!visited[i]) {
                    visited[i]=true
                    q.add(i)
                    cnt++
                }
            }
        }
        return cnt
    }
}