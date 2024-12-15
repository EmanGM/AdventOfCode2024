import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    val grid = readFileLineByLine("inputs/day6.txt", "A")
}

fun readFileLineByLine(fileName: String, part: String): ArrayList<CharArray> {

    var matrix: Array<Array<Int>> = Array(MAP_SIZE) {Array(MAP_SIZE) {-1} }
    var movements: ArrayList<CharArray> = arrayListOf<CharArray>()
    var lineNumber = 0
    var i = 0
    var j = 0
    var isSequenceLine = false
    File(fileName).inputStream().bufferedReader().forEachLine { 

        if(isSequenceLine) {
            movements.addAll(it)

        } else {
            if(it == "") {
                isSequenceLine = true
            }
            matrix.add(it.toCharArray())
            if(it.indexOf("^") != -1) {
                i = lineNumber
                j = it.indexOf("^")
            }
            lineNumber++
        }
    }
    printMatrix(matrix)
    println("$i, $j")
    walk(matrix, i, j)
    return matrix
}

fun walk(matrix: ArrayList<CharArray>, x: Int, y: Int) {
    var direction = "UP"
    var walking = true
    var i: Int = x
    var j: Int = y
    var steps: Int = 1
    matrix[x][y] = 'O' // guard first position
    while(walking) {
        when(direction) {
            "^" -> {
                if(matrix[i-1][j] == '#') {
                    direction = "RIGHT"
                } else {
                    i--
                    if(i - 1 < 0) {
                        walking = false
                    }
                }
            }
            ">" -> {
                if(matrix[i][j+1] == '#') {
                    direction = "DOWN"
                } else {
                    j++
                    if(j + 1 >= matrix[i].size) {
                        walking = false
                    }
                }
            }
            "V" -> {
                if(matrix[i+1][j] == '#') {
                    direction = "LEFT"
                } else {
                    i++
                    if(i + 1 >= matrix.size) {
                        walking = false
                    } 
                }
            }
            "<" -> {
                if(matrix[i][j-1] == '#') {
                    direction = "UP"
                } else {
                    j--
                    if(j - 1 < 0) {
                        walking = false
                    } 
                }
            }
        }
        if(matrix[i][j] != 'O') {
            matrix[i][j] = 'O'
            steps++
        }
        //println(steps)
        //printMatrix(matrix)
    }
    println("final steps: $steps")
}

fun printMatrix(matrix: ArrayList<CharArray>) {
    for(m in matrix) {
        println(m)
    }
    println()
}