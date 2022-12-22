class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer = 0.0

        fun getY(position: Int): Double {
            return Math.sqrt(Math.pow(d.toDouble(), 2.0) - Math.pow(position.toDouble(), 2.0))
        }
        for (i in 0..d step (k)) {
            answer += (Math.floor(getY(i) / k) + 1)
        }
        return answer.toLong()
    }
}