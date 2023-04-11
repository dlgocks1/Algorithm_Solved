import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val visited = BooleanArray(y+1) { false } 
        val q = LinkedList<Pair<Int, Int>>()
        q.add(x to 0)
        visited[x] = true
        
        while(q.isNotEmpty()) {    
            val (curNum, count) = q.poll()
            
            if(curNum == y) return count

            if(curNum + n <= y && !visited[curNum +n]) {
                q.add(curNum + n to count + 1)
                visited[curNum + n] = true
            }
            if(curNum * 2 <= y && !visited[curNum * 2]) {
                q.add(curNum * 2 to count + 1)
                visited[curNum * 2] = true
            }
            if(curNum * 3 <= y && !visited[curNum * 3]) {
                q.add(curNum * 3 to count + 1)
                visited[curNum * 3] = true
            }
        }
        
        return -1
    }
}