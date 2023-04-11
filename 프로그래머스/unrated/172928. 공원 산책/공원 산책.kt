class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        
        var curPosition: IntArray = intArrayOf(0,0)
        park.forEachIndexed { y, column ->
            column.forEachIndexed { x, str ->
                if(str == 'S') {
                    curPosition[0] = y
                    curPosition[1] = x
                }
            }
        }
        
        val verticalDist = park.size
        val horizontalDist = park.first().length
        
        routes.forEach { route ->
            val (direction, distStr) = route.split(" ")
            val dist = distStr.toInt()
            var flag = true
            when(direction) {
                "E" -> {
                    val mx = dist + curPosition[1]
                    if(mx in 0 until horizontalDist) {
                        (curPosition[1]..mx).forEach { dx ->
                            if(park[curPosition[0]][dx] == 'X') flag = false
                        }
                        if(flag) curPosition[1] = mx
                    }
                }
                "W" -> {
                    val mx = curPosition[1] - dist
                    if(mx in 0 until horizontalDist) {
                        (curPosition[1]-dist..curPosition[1]).forEach { dx ->
                            if(park[curPosition[0]][dx] == 'X') flag = false
                        }
                        
                        if(flag) curPosition[1] = mx
                    }
                }
                "S" -> {
                    val my = curPosition[0] + dist
                    if(my in 0 until horizontalDist) {
                        (curPosition[0]..my).forEach { dy ->
                            if(park[dy][curPosition[1]] == 'X') flag = false
                        }
                        if(flag) curPosition[0] = my
                    }
                }    
                "N" -> {
                     val my = curPosition[0] - dist
                    if(my in 0 until horizontalDist) {
                        (curPosition[0]-dist..curPosition[0]).forEach { dy ->
                            if(park[dy][curPosition[1]] == 'X') flag = false
                        }
                        if(flag) curPosition[0] = my
                    }
                }
                else -> {}
            }
        }
        
        return curPosition
    }
}