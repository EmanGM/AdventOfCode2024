import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val total = readFileLineByLine("inputs/day3.txt", "A")
    println("Total: " + total)
}

fun readFileLineByLine(fileName: String, part: String): Long {

    val regex = """mul\(\d+,\d+\)""".toRegex()
    var total: Long = 0;
    val fileText: String = File(fileName).readText(Charsets.UTF_8) 
    var matchResult = regex.find(fileText)

    var match = null
    do {
       var match = matchResult!!.value.split(",")
       val left = match[1]
       total += match[0].substring(4).toInt() * left.substring(0, left.length - 1).toInt()
       matchResult = matchResult?.next()
    }
    while(matchResult != null)

    if(part == "B") {
        val doRegex = """do\(\)""".toRegex()
        val dontRegex = """don't\(\)""".toRegex()
    }
            
    return total
}