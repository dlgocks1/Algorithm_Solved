import java.util.*

class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        val graph = List<MutableList<Int>>(n+1) { mutableListOf() }
        roads.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        // println(graph)
       
        val dist = bfs(graph, n, destination)
        sources.forEach {
            answer += dist[it]
        }
       
        return answer
    }
    
    fun bfs(graph:List<List<Int>>, size:Int, start:Int) :List<Int> {
        
        val dist = MutableList<Int>(size+1) { -1 }
        
        val q = LinkedList<Pair<Int,Int>>()
        q.add(start to 0)
        dist[start] = 0
        while(q.isNotEmpty()) {
            val (cur, cnt) = q.poll()
            for(i in graph[cur]) {
                if(dist[i] == -1) {
                    dist[i] = cnt + 1
                    q.add(i to cnt + 1)
                }
            }
        }
        
        return dist
    }
}