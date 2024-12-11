import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    val total = readFileLineByLine("inputs/day11.txt")
    println("Total: " + total)
}

fun readFileLineByLine(fileName: String): Long {

    var total: Long = 0;
    val fileText: String = File(fileName).readText(Charsets.UTF_8) 

    var stones: List<Long> = arrayListOf<Long>()
    //storing stones that already occur
    var match = null
            
    return total
}