import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        val routes = generateGraph(n, edge)
        val distance = MutableList(n+1) { Int.MAX_VALUE }
        
        val q = LinkedList<Int>()
        distance[1] = 0
        q.add(1)
        while(q.isNotEmpty()) {
            val now:Int = q.poll()
            for(next in routes[now]) {
                if(distance[next] > distance[now] + 1) {
                    distance[next] = distance[now] + 1
                    q.add(next)
                }
            }
        }
        
        val maxDistance = distance
            .filter { it != Int.MAX_VALUE && it != 0}
            .maxOrNull() ?: 0
        
        return distance
            .filter { it != Int.MAX_VALUE && it != 0}
            .filter{ it == maxDistance }.count()
    }
    
    fun generateGraph(n: Int,edge:Array<IntArray>): List<MutableList<Int>> {
       val routes = List<MutableList<Int>>(n+1) { mutableListOf<Int>() }
        edge.forEach { node ->
            routes[node[0]].add(node[1])
            routes[node[1]].add(node[0])
        }
        return routes
    }
}