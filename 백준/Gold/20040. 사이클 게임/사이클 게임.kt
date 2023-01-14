import kotlin.system.exitProcess

lateinit var parent: IntArray

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(' ').map{it.toInt()}

    parent = IntArray(n){it}

    for(i in 1..m){
        val (p1, p2) = readLine().split(' ').map { it.toInt() }
        if(find(p1) == find(p2)){
            print(i)
            exitProcess(0)
        }
        union(p1, p2)
    }
    print(0)
}

fun find(x: Int): Int{
    if(x == parent[x])
        return x
    else{
        val p = find(parent[x])
        parent[x] = p
        return parent[x]
    }
}

fun union(x: Int, y: Int){
    val rootX = find(x)
    val rootY = find(y)

    parent[rootY] = rootX
}