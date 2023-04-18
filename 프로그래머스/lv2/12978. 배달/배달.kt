import java.util.PriorityQueue

class Solution {
    
    fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
        var graph = List<MutableList<Pair<Int,Int>>>(n+1){ mutableListOf() }
        road.forEach {
            graph[it[0]].add(it[1] to it[2])
            graph[it[1]].add(it[0] to it[2])
        }
          
        return dijstra(graph, n).filter { it <= k }.count()   
    }
    
    fun dijstra(graph:List<List<Pair<Int,Int>>>, size: Int): List<Int> {
        
        val distance = MutableList<Int>(size+1) { Int.MAX_VALUE }
        
        val pq = PriorityQueue<Pair<Int,Int>> { a, b ->
            a.second.compareTo(b.second)
        }
        pq.add(1 to 0)
        distance[1] = 0
        
        while(pq.isNotEmpty()) {
            val (now, dist) = pq.poll()
            for(i in graph[now]) {
                val nextdest = i.first
                val cost = i.second
                if(distance[nextdest] > dist + cost) {
                    pq.add(nextdest to dist + cost)
                    distance[nextdest] = dist + cost
                }
            }    
        }
        
        return distance
    }
}


// import java.util.PriorityQueue
// class Solution {
//     private val dq = PriorityQueue<Pair<Int,Int>>(Comparator{
//         a,b->
//         when{
            // a.second < b.second -> -1
            // a.second > b.second -> 1
            // else -> 0
//         }
//     })

//     fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
//         var graph = Array<ArrayList<Pair<Int,Int>>>(n+1){ ArrayList() }
//         for (i in road){
//             graph[i[0]].add(Pair(i[1],i[2]))
//             graph[i[1]].add(Pair(i[0],i[2]))
//         }

//         fun dijkstra(start:Int): IntArray {
//             var distances = IntArray(n+1,{i->987654321})
//             distances[start] = 0
//             dq.add(Pair(start,0))
//             while(dq.isNotEmpty()){
//                 var (now,nowdist) = dq.poll()
//                 if (distances[now] < nowdist) continue
//                 for(i in graph[now]){
//                     var cost = nowdist + i.second
//                     var nextdes = i.first
//                     if (distances[nextdes] > cost){
//                         distances[nextdes] = cost
//                         dq.add(Pair(nextdes,cost))
//                     }
//                 }
//             }
//             return distances
//         }

//         var ans = dijkstra(1)
//         var cnt = 0
//         for(i in ans){
//             println(i)
//             if (i<=k){
//                 cnt+=1
//             }
//         }
//         return cnt
//     }
// }