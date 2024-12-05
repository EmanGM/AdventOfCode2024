import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val total = readFileLineByLine("inputs/day5.txt", "A")
    println("Total: " + total)
}

fun readFileLineByLine(fileName: String, part: String): Long {

    var total: Long = 0;

    val pages = mutableMapOf<Number, Array<Number>>()


    val inputStream: InputStream = File(fileName).inputStream()
    inputStream.bufferedReader().forEachLine { 
        // if(!it.contains("|")) {
        //     return
        // }
        val numbers = it.split("|")
        val left = numbers[0].toInt()
        val right = numbers[1].toInt()
        if(pages.containsKey(left)) {

        } else {
            pages.put(left, arrayOf(right))
        } 
    }

    pages.forEach {
        println("$it.key, $it.value")
    }

    // for(n in numbers) {
    //     current = n.toInt()
    //     println(abs(current - previous))
    //     if(previous != 0) {
    //         var currrentDirection = if(current - previous > 0) 1 else -1
    //         if(abs(current - previous) == 0 || abs(current - previous) > 3 || direction != currrentDirection) {
    //             safe = false
    //         }
    //         direction = currrentDirection;
    //     }
    //     previous = current
    // } 
            
    return total
}