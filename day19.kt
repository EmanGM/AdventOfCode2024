import java.io.File
import java.io.InputStream


var towels: ArrayList<String> = arrayListOf<String>()
var designs: ArrayList<String> = arrayListOf<String>()

fun main(args: Array<String>) {

    val grid = readFileLineByLine("inputs/day19.txt")
}

fun readFileLineByLine(fileName: String) {

    var isDesign = false
    File(fileName).inputStream().bufferedReader().forEachLine { 
        if(isDesign) {

        } else {

        }
        if(it == "") {
            isDesign = true
        }
    }
}

