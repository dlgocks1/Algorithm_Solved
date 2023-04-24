class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var visited = BooleanArray(10_001) { false }
        val startArr = IntArray(topping.size) { 0 } 
        val endArr = IntArray(topping.size) { 0 } 
        
        if(topping.size ==1) return 0
        if(topping.size ==2) return 1
        
        // setStartArr
        var count = 0
        for(i in topping.indices) {
            if(!visited[topping[i]]) {
                visited[topping[i]] = true
                count ++
            }
            startArr[i] = count
        }
        
        // setEndArr
        visited = BooleanArray(10_001) { false }
        count = 0
        for(i in topping.size-1 downTo 0) {
            if(!visited[topping[i]]) {
                visited[topping[i]] = true
                count ++
            }
            endArr[i] = count
        }
        
        
        for(i in 0 until topping.size-1) {
            if(startArr[i] == endArr[i+1]) answer++
            // println("startArr[i] ${startArr[i]}")
            // println("endArr[i] ${endArr[i]}")
        }
        
        
        return answer
    }
}