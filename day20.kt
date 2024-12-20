import java.io.File
import java.io.InputStream

var maze: ArrayList<CharArray> = arrayListOf<CharArray>()
var start = Pair()
var end = Pair()

fun main(args: Array<String>) {

    val grid = readFileLineByLine("inputs/day20.txt")
    
}

fun readFileLineByLine(fileName: String): ArrayList<CharArray> {

    var maze: ArrayList<CharArray> = arrayListOf<CharArray>()
    var lineNumber = 0
    var i = 0
    var j = 0
    File(fileName).inputStream().bufferedReader().forEachLine { 
        matrix.add(it.toCharArray())
        if(it.indexOf("S") != -1) {
            i = lineNumber
            j = it.indexOf("S")
            start = Pair(i, j)
        }
        if(it.indexOf("E") != -1) {
            i = lineNumber
            j = it.indexOf("E")
            end = Pair(i, j)
        }
        lineNumber++
    }
    printMatrix(matrix)
    println("$i, $j")
    return maze
}

fun finPath(): List<Pair<Int, Int>> {
    //The idea is to have a linked list of points that give the path
    //and then see which wall are possible to go through
}