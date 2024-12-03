import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val total = readFileLineByLine("inputs/test.txt", "A")
    println("Total: " + total)
}

fun readFileLineByLine(fileName: String, part: String): Long {

    var total: Long = 0;
    val inputStream: InputStream = File(fileName).inputStream()
    inputStream.bufferedReader().forEachLine { 
        val numbers = it.split(" ")
        var previous = 0; 
        var current = 0;
        var direction = 0;
        var safe = true
        for(n in numbers) {
            current = n.toInt()
            println(abs(current - previous))
            if(previous != 0) {
                var currrentDirection = if(current - previous > 0) 1 else -1
                if(abs(current - previous) == 0 || abs(current - previous) > 3 || direction != currrentDirection) {
                    safe = false
                }
                direction = currrentDirection;
            }
            previous = current
        }  
        if(safe) {
            total++
        }
        println()
    }
            
    return total
}