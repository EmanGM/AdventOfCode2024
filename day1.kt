import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val sum = readFileLineByLine("inputs/day1.txt", "A")
    println("Sum: " + sum)
}

fun readFileLineByLine(fileName: String, part: String): Long {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    val inputStream: InputStream = File(fileName).inputStream()
    inputStream.bufferedReader().forEachLine { 
        val numbers = it.split("   ")
        left.add(numbers[0].toInt()) 
        right.add(numbers[1].toInt()) 
    } 

    left.sort()
    right.sort()
    var sum: Long = 0;

    if(part == "A") {
        for (i in left.indices) {
            sum += abs(right[i] - left[i])
            println(">  " + abs(right[i] - left[i]))
        }
    }

    if(part == "B") {
        for(n in left) {
            val occurences = right.count{ it == n}
            println(occurences)
            sum += n * occurences 
        }
    }
            
    return sum
}