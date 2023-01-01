import java.util.Stack

private var answer = Int.MAX_VALUE

fun main() {
    val N = readLine()!!.toInt()
    val scoreBoard = mutableListOf<List<Int>>()
    repeat(N) {
        scoreBoard.add(readLine()!!.split(" ").map { it.toInt() })
    }
    val pair = List(N) { it }
    for (index in 0 until N / 2) {
        dfs(index, N, pair, Stack<Int>(), scoreBoard)
    }
    println(answer)
}

private fun dfs(index: Int, n: Int, pair: List<Int>, stack: Stack<Int>, scoreBoard: List<List<Int>>) {

    if (stack.size == n / 2) {
        // Stack이 스타트팀
        val startTeam = stack
        val linkTeam = mutableListOf<Int>()
        linkTeam.apply {
            addAll(pair)
            removeAll(stack)
        }
        var startScore = 0
        var linkScore = 0
        for (i in startTeam.indices) {
            for (j in i + 1 until startTeam.size) {
                startScore += scoreBoard[startTeam[i]][startTeam[j]]
                startScore += scoreBoard[startTeam[j]][startTeam[i]]
            }
        }
        for (i in linkTeam.indices) {
            for (j in i + 1 until linkTeam.size) {
                linkScore += scoreBoard[linkTeam[i]][linkTeam[j]]
                linkScore += scoreBoard[linkTeam[j]][linkTeam[i]]
            }
        }
        answer = Math.min(answer, Math.abs(startScore - linkScore))
    }

    for (i in index until pair.size) {
        stack.push(pair[i])
        dfs(i + 1, n, pair, stack, scoreBoard)
        stack.pop()
    }

}

