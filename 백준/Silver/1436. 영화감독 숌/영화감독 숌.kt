fun main() {

    val N = readLine()!!.toInt()
    val find = "666"
    var movie = 666
    var serise = 0

    while (true) {
        if (movie.toString().contains(find)) {
            serise++
            if (serise == N) {
                break
            }
        }
        movie++
    }
    println(movie)
}
