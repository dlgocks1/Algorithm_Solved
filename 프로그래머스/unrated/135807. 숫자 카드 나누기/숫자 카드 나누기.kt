class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        
        var maxA = (arrayA.maxOrNull() ?: 0)
        var gcdA = ArrayList<Int>()
        while(maxA>0){
            if(arrayA.all { it % maxA == 0 })
            gcdA.add(maxA)
            maxA--
        }   
        
        var maxB = (arrayB.maxOrNull() ?: 0)
        var gcdB = ArrayList<Int>()
        while(maxB > 0){
            if(arrayB.all { it % maxB == 0 })
            gcdB.add(maxB)
            maxB--
        }   
        
        // println(gcdA)
        // println(gcdB)
        
        val answer = Math.max(
            (gcdA.filter { item -> arrayB.all { it % item != 0} }).maxOrNull() ?: 0, 
            (gcdB.filter { item -> arrayA.all { it % item != 0} }).maxOrNull() ?: 0
        )
        
        return answer
    }
}