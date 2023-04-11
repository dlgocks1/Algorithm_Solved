class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
       
        val hashMap = hashMapOf<String,Int>()
        players.forEachIndexed { idx, player ->
            hashMap[player] = idx
        }

        callings.forEach { call->
            val curIdx = hashMap[call]!!
            val front = players[curIdx-1]
            players[curIdx-1]  = players[curIdx]
            players[curIdx] = front

            hashMap[call] = hashMap[call]!! - 1
            hashMap[front] = hashMap[front]!! + 1
        }
        
        return players
    }
}