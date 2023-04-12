class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
        val albums = mutableListOf<Triple<String,Int,Int>>() // 장르, 플레이 횟수, 고유 번호
        
        val playSums = mutableMapOf<String,Int>()
        val genreNames = genres.toSet()
        
        genres.forEachIndexed { idx, genre ->
            albums.add(Triple(genre, plays[idx], idx))
        }
                
        genreNames.forEach { name ->
            playSums[name] = albums
                .filter { it.first == name }
                .sumOf { it.second }
        }
        
        playSums.toList().sortedBy { -it.second }.forEach { playSum ->
            albums.filter { it.first == playSum.first }
                .sortedBy { it.third }
                .sortedBy { -it.second }
                .take(2)
                .forEach {
                    answer += it.third
                }
        }

        return answer
    }
}