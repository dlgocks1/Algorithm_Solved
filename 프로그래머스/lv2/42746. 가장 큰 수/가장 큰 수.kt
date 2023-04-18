class Solution {
    fun solution(numbers: IntArray): String 
            = numbers
                .map { it.toString() }
                .sortedWith { t1, t2 ->
                    (t2 + t1).compareTo(t1 + t2)
                }.joinToString("")
                .let {
                    if(it[0] == '0') "0"
                    else it
                }
}