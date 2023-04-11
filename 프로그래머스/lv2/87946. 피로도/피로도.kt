import java.util.*

class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        var curK = k
        val visited = MutableList(dungeons.size) { false }
        val result = Stack<IntArray>()
        
        fun dfs() {
            answer = Math.max(result.size, answer)
            for(i in dungeons.indices) {
                val dungeon = dungeons[i]
                if(!visited[i] && curK >= dungeon[0]){
                    curK -= dungeon[1]
                    result.add(dungeon)
                    visited[i]= true
                    dfs()
                    
                    curK += dungeon[1]
                    result.pop()
                    visited[i]=false
                }
            }
        }
        
        dfs()
        return answer
    }
}