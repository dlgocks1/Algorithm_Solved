class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var xCounter = 0
        var yCounter = 0
        var fixedChar: Char = s.first()
        s.forEach {
            if (fixedChar == ' ') {
                fixedChar = it
            }
            if (fixedChar == it) {
                fixedChar = it
                xCounter += 1
            } else {
                yCounter += 1
            }
            if (xCounter == yCounter) {
                answer += 1
                xCounter = 0
                yCounter = 0
                fixedChar = ' '
            }
        }
        if (fixedChar != ' ') {
            answer++
        }
        return answer
    }

}