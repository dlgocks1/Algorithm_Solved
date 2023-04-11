import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = -1
        
        val q1 = LinkedList<Long>()
        val q2 = LinkedList<Long>()
        queue1.forEach { q1.add(it.toLong()) }
        queue2.forEach { q2.add(it.toLong()) }

        val sumOfQueues = q1.sum() + q2.sum()
        if(sumOfQueues % 2 == 1L) return -1
        val halfOfSums = sumOfQueues / 2
        if(q1.any { it > halfOfSums } || q2.any { it > halfOfSums }) return -1
        
        
        var cnt = 0
        var q1Sum = q1.sum()
        var q2Sum = q2.sum()
        while(true) {
            if(cnt > 600_000) return -1
            if (q1Sum == halfOfSums) {
                break
            } else if(q1Sum > q2Sum) {
                val popped = q1.pop()
                q2.add(popped)
                q1Sum -= popped
                q2Sum += popped
                cnt +=1
            } else {
                val popped = q2.pop()
                q1.add(popped)
                q1Sum += popped
                q2Sum -= popped
                cnt +=1
            }
        }
        
        return cnt
    }
}