import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val total = readFileLineByLine("inputs/day9.txt")
    println("Total: " + total)
}

fun readFileLineByLine(fileName: String): Long {

    var total: Long = 0;
    val fileText: String = File(fileName).readText(Charsets.UTF_8) 
            
    return total
}