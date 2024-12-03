import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val total = readFileLineByLine("inputs/day3.txt", "A")
    println("Total: " + total)
}

fun readFileLineByLine(fileName: String, part: String): Long {

    val regex = """mul\(\d+,\d+""".toRegex()
    var total: Long = 0;
    val fileText: String = File(fileName).readText(Charsets.UTF_8) 
    var matchResult = regex.find(fileText)

    var match = null
    var m = matchResult
    do {
       var match = m!!.value.split(",")
       println("match: $match")
       total += match[0].substring(4).toInt() * match[1].toInt()
       m = matchResult?.next()
    }
    while(m != null)
            
    return total
}