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
    inputStream.bufferedReader().forEachLine loop@ { 
        if(!it.contains("|")) {
            return@loop
        }
        val numbers = it.split("|")
        val left = numbers[0].toInt()
        val right = numbers[1].toInt()
        if(pages.containsKey(left)) {
            pages.get(left)!!.plus(right)
            //println(pages.get(left) is Array)
        } else {
            pages.put(left, arrayOf(right))
        } 
    }

    for ((k, v) in pages) {
        println("$k = ")
        for(a in v) {
            print(a)
        }
        print("  ")
        //v.forEach { print(v) }
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