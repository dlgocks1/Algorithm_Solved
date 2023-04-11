import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0

        val subContainer = Stack<Int>()
        val budgets = LinkedList<Int>().apply {
            (1..order.size).forEach {
                add(it)
            }
        }
        var nextIdx = 0

        while(true) {
            if(nextIdx == order.size) return nextIdx
            
            val nextOrder = order[nextIdx]
            if(budgets.isNotEmpty() && budgets.first() == nextOrder) {
                budgets.poll()
                nextIdx++
            } else if (subContainer.isNotEmpty() && subContainer.last() == nextOrder ){
                subContainer.pop()
                nextIdx++
            } else {
                if(budgets.isEmpty()) return nextIdx
                subContainer.add(budgets.poll())
            }
        }
        
        return nextIdx
    }
}