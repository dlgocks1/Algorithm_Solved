class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        
        if(!words.contains(target)) return 0

        var answer = Int.MAX_VALUE
        val visited = BooleanArray(words.size) { false }

        fun dfs(now:String, cnt:Int) {
            if(now == target) answer = Math.min(answer, cnt)
            
            for(position in words.indices) {
                // println("$now ${words[position]}")
                // println(diffWordsCount(now, words[position]))
                if(!visited[position] &&
                   diffWordsCount(now, words[position]) == 1
                ) {
                    visited[position] = true    
                    dfs(words[position], cnt +1)
                    visited[position] = false 
                }
            }
        }
        
        dfs(begin,0)
        
        return if(answer == Int.MAX_VALUE) 0 else answer
    }
    
    
    fun diffWordsCount(str1: String, str2: String): Int {
        var answer = 0
        str1.forEachIndexed { idx, char ->
            if(str2[idx] != char) answer +=1
        }
        return answer
    }
}