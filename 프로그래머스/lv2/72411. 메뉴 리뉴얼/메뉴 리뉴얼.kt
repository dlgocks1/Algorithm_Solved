import java.util.*

class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val courseMap = mutableMapOf<String,Int>()
        
        orders.forEach { order->
            course.forEach { size ->
                divideMenus(order.toCharArray().sorted().joinToString(""), size).forEach { menu ->
                    if(courseMap[menu] == null) {
                        courseMap[menu] = 1
                    } else {
                        courseMap[menu] = courseMap[menu]!! + 1
                    }    
                }                
            }
        }
        
        course.forEach { size ->
            val filtered = courseMap.filter { it.key.length == size && it.value >= 2 }
            val maxSize = filtered.values.maxOrNull()
            maxSize?.let { 
                filtered.filter { it.value == maxSize }.forEach { item->
                    answer += item.key
                }
            }            
        }
        
        return answer.sorted().toTypedArray()
    }
    
    
    fun divideMenus(menus:String, size: Int): List<String> {
        
        val resultArr = mutableListOf<String>()
        val stack = Stack<Char>()
        
        fun dfs(idx: Int) {
            if(stack.size == size) {
                val temp = StringBuilder()
                stack.forEach {
                    temp.append(it)
                }
                resultArr.add(temp.toString())
                return
            }
            for(i in idx until menus.length) {
                stack.add(menus[i])
                dfs(i+1)
                stack.pop()
            }
        }
        
        dfs(0)
        
        return resultArr
    } 
}