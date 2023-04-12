class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        val routes = List<MutableList<Int>>(n+1) { mutableListOf<Int>() }
        val isvisited = BooleanArray(n+1) { false }
        
        computers.forEachIndexed { idx, computer ->
            computer.forEachIndexed { position, linked ->
                if(position == idx) return@forEachIndexed
                if(linked == 1) routes[idx+1].add(position+1)
            }
        }
        
        fun dfs(idx: Int) {
            isvisited[idx] = true
            for(route in routes[idx]) {
                if(!isvisited[route]) {
                    dfs(route)
                }
            }
        }
                
        for(now in 1..n) {
            if(!isvisited[now]) {
                dfs(now)
                answer +=1
            }
        }
        

        
        return answer
    }
}