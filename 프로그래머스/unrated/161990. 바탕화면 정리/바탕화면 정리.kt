import java.util.*

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var minX = Int.MAX_VALUE
        var minY = Int.MAX_VALUE
        var maxX = -1
        var maxY = -1
        
        wallpaper.forEachIndexed { y, paper ->
            paper.forEachIndexed { x, char ->
                if(char=='#') {
                    minX = Math.min(minX, x)
                    minY = Math.min(minY, y)
                    maxX = Math.max(maxX, x)
                    maxY = Math.max(maxY, y)
                }
            }           
        }
        answer += minY
        answer += minX
        answer += maxY +1
        answer += maxX +1
        return answer
    }
}