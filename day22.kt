import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    val grid = readFileLineByLine("inputs/day22.txt")    
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
        lineNumber++
    }
    printMatrix(matrix)
    println("$i, $j")
    return maze
}



fun stepOne(secret: Long, value: Long): Long {

}


fun stepTwo(secret: Long, value: Long): Long {

}


fun stepThree(secret: Long, value: Long): Long {

}

fun mix(secret: Long, value: Long): Long {

}

fun prune(secret: Long, value: Long): Long {

}