class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        
        val banMap = BooleanArray(banned_id.size) { false }
        val visited = BooleanArray(user_id.size) { false }
        val results = mutableSetOf<List<String>>()
        val result = mutableListOf<String>()
        
        fun dfs(uposition:Int, bposition:Int, cnt:Int) {
            
            if(cnt == banned_id.size) {
                // println(result)
                results.add(result.sorted().toList())
                return 
            }
            
            for(userIdx in uposition until user_id.size) {
                if(!visited[userIdx]) {
                    for(banIdx in bposition until banned_id.size) {
                        if(banMap[banIdx]) continue
                        if(idMatch(user_id[userIdx], banned_id[banIdx])) {
                            banMap[banIdx] = true
                            visited[userIdx] = true
                            result.add(user_id[userIdx])    
                            dfs(userIdx+1, 0,cnt+1)
                            result.remove(user_id[userIdx])    
                            banMap[banIdx] = false
                            visited[userIdx] = false
                        }
                    }
                }
            }
        }
        
        dfs(0,0,0)
        
        return results.size 
    }
    
    fun idMatch(userId:String, banId: String):Boolean {
        if(userId.length != banId.length) return false
        banId.forEachIndexed { idx, banChar ->
            if(banChar == '*') {
                return@forEachIndexed  
            } else {
                if(userId[idx] != banChar) return false 
            }
        }    
        return true
    }
    
}