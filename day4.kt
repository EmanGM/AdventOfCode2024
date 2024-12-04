import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main(args: Array<String>) {

    val grid = readFileLineByLine("inputs/test.txt", "A")
}

fun readFileLineByLine(fileName: String, part: String): Long {

    var matrix: Array<Array<Char>>
    var lineNumber = 0
    val inputStream: InputStream = File(fileName).inputStream()
    inputStream.bufferedReader().forEachLine { 
        matrix[lineNumber] = it.toCharArray
        lineNumber++
    }
    return matrix
}