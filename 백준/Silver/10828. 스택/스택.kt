import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

class Stack() {

    private val contents = mutableListOf<Int>()

    val empty: Int
        get() = if(contents.isEmpty()) 1 else 0
    val size: Int
        get() = contents.size
    val top: Int
        get() = contents.lastOrNull() ?: -1

    fun push(arg: Int) {
        contents.add(arg)
    }

    fun pop(): Int {
        if(contents.isEmpty()) return -1
        return contents.removeAt(contents.lastIndex)
    }

}


fun main() {
    val stack = Stack()
    repeat(reader.readLine().toInt()) {
        val commands = reader.readLine().split(" ")
        val command = commands.first()
        if(command == "push"){
            stack.push(commands[1].toInt())
        }else if(command == "top"){
            println(stack.top)
        }else if(command == "size"){
            println(stack.size)
        }else if(command == "empty"){
            println(stack.empty)
        }else if(command=="pop") {
            println(stack.pop())
        }
    }
}