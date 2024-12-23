import java.io.File
import java.io.InputStream


fun main(args: Array<String>) {

    val sets = readFileLineByLine("inputs/day22.txt")
    
}

fun readFileLineByLine(fileName: String): ArrayList<String> {

    var connections: ArrayList<String> = arrayListOf<String>()
    var promoted: ArrayList<String> = arrayListOf<String>()

    File(fileName).inputStream().bufferedReader().forEachLine { 
        val pairs = it.splt("-")
        val c1 = pairs[0]
        val c2 = pairs[1]
    }
    return promoted
}