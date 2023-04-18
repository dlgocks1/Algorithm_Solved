class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        
        var sortedData = data.sortedBy { -it[0] }.sortedBy { it[col-1] }
        
        // sortedData.forEach{
        //     println(it.contentToString())
        // }
        
        val results = ArrayList<Int>()
        for(i in row_begin-1..row_end-1) {
            var sum = 0
            sortedData[i].forEach {
                sum += it % (i +1)
            }
            results.add(sum)
        }
        
        // println(results)
        answer = results[0]
        for(i in 1 until results.size){
            answer = answer xor results[i] 
        }
        
        return answer
    }
}