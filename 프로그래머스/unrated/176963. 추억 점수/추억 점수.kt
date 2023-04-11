class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        
        val scoreMap = mutableMapOf<String,Int>()
        
        name.forEachIndexed { idx, str -> 
            scoreMap[str] = yearning[idx]
        }
        
        photo.forEach { picture ->
            var sum = 0
            picture.forEach{ 
               sum += scoreMap[it] ?: 0
            }
            answer += sum
        }
    
        
        return answer
    }
}