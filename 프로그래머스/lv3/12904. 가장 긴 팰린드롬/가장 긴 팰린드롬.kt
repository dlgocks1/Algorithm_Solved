class Solution {
    
    var str = ""
    fun solution(s: String): Int {
        var answer = 1
        str = s
        for(i in s.length downTo 1) {
            for(startIdx in 0 until s.length - i){
                if(isPallindrome(startIdx, i+startIdx)) return i + 1
            }
        }
        
        return answer
    }
    
    fun isPallindrome(startIdx: Int, endIndex: Int): Boolean {
        var startIdx = startIdx
        var endIndex = endIndex
        while (startIdx < endIndex) {
            if (str[startIdx] != str[endIndex]) {
                return false
            }
            startIdx++
            endIndex--
        }
        return true
    }
    
}