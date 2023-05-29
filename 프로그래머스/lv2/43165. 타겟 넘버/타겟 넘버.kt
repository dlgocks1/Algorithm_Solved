class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        fun bfs(now: Int,sum: Int) {
            if(target == sum && now == numbers.size - 1) {
                answer +=1
            }
            if(now + 1 > numbers.size-1) return
            bfs(now+1, sum + numbers[now+1])
            bfs(now+1, sum - numbers[now+1])
        }
        
        bfs(0, numbers[0])
        bfs(0, -numbers[0])
        
        return answer
    }
}