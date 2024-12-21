import java.io.File
import java.io.InputStream


fun main(args: Array<String>) {

    //val grid = readFileLineByLine("inputs/day20.txt")
    val nextSequence = convertToDirectionalKeyPad("<A^A>^^AvvvA".toMutableList())
    nextSequence.forEach { println(it) }
}

fun readFileLineByLine(fileName: String): ArrayList<CharArray> {

    var maze: ArrayList<CharArray> = arrayListOf<CharArray>()
    var lineNumber = 0
    var i = 0
    var j = 0
    File(fileName).inputStream().bufferedReader().forEachLine { 
        maze.add(it.toCharArray())
    }
    return maze
}

fun convertToDirectionalKeyPad(instructions: MutableList<Char>): MutableList<Char> {
    val result = mutableListOf<Char>()
    for(i in instructions.indices) {
        val first = instructions[i]
        if(i + 1 >= instructions.size) {
            break
        }
        val second = instructions[i + 1]
        println("first: $first, second: $second")
        if(first == second) {
            result.add('A')
        } else if(first == '<') {
            result.add('>')
        } else if(first == '^' && second != 'A') {
            result.add('v')
        } else if(first == '^' && second == 'A') {
            result.add('>')
        } else if(first == 'A' && second == '^') {
            result.add('<')
        } else if(first == 'A' && second != '^') {
            result.add('v')
        } else if(first == '>' && second == 'A') {
            result.add('^')
        } else if(first == '>' && second != 'A') {
            result.add('<')
        } else if(first == 'v' && second == '<') {
            result.add('<')
        } else if(first == 'v' && second == '^') {
            result.add('^')
        } else if(first == 'v') {
            result.add('>')
        } else {
            println("No mapping")
        }
    }
    return result
}