import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    val grid = readFileLineByLine("inputs/day8.txt", "A")
}

fun readFileLineByLine(fileName: String, part: String): ArrayList<CharArray> {

    var matrix: ArrayList<CharArray> = arrayListOf<CharArray>()
    val antennas = mapOf<String, List<Pair<Int, Int>>>()
    var lineNumber = 0
    var i = 0
    var j = 0
    File(fileName).inputStream().bufferedReader().forEachLine { 
        matrix.add(it.toCharArray())
        if(it.indexOf(".") != -1) {
            i = lineNumber
            j = it.indexOf(".")
        }
        antennas.put()
        lineNumber++
    }
    printMatrix(matrix)
    println("$i, $j")
    walk(matrix, i, j)
    return matrix
}

fun printMatrix(matrix: ArrayList<CharArray>) {
    for(m in matrix) {
        println(m)
    }
    println()
}