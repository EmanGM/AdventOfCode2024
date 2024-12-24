import java.io.File
import java.io.InputStream

var variables: MutableMap<String, Int> = mutableMapOf<String, Int>()
var gates: ArrayList<Gate> = arrayListOf<Gate>()

fun main(args: Array<String>) {

    readFileLineByLine("inputs/day24.txt")
    
    activateGates()
    // for(gate in gates) {
    //     println(gate)
    // }
    
    val sorted = variables.entries.sortedBy {it.key }.reversed()
    println()
    
    var result: Long = 0
    for(v in sorted) {
        if(v.key.startsWith("z")) {
            result = (result shl 1) or v.value.toLong()
            println("$v $result")
        }
    }
}

fun readFileLineByLine(fileName: String) {

    var isReadingVariables = true
    File(fileName).inputStream().bufferedReader().forEachLine { 
        if(isReadingVariables) {
            if(it == "") {
                isReadingVariables = false
            } else {
                val values = it.split(" ")
                variables.put(values[0].substring(0, 3), values[1].toInt())
            }
        } else {
            val values = it.split(" ")
            gates.add(Gate(values[0], values[2], values[1], values[4]))
        }
    }
}

fun activateGates() {
    var activatedGates = 0
    while(activatedGates < gates.size) {

        for(gate in gates) {
            if(gate.input1 in variables) {
                gate.input1value = variables.get(gate.input1)
            }
            if(gate.input2 in variables) {
                gate.input2value = variables.get(gate.input2)
            }
            if(!gate.alreadyActivated and (gate.input1value != null) and (gate.input2value != null)) {
                gate.calc()
                activatedGates++
                variables.put(gate.output, gate.outputvalue!!)
            }
        }
    
    }
}

class Gate(
    var input1: String, 
    var input2: String,
    var operation: String,
    var output: String
) { 
    var input1value: Int? = null
    var input2value: Int? = null
    var outputvalue: Int? = null
    var alreadyActivated: Boolean = false

    fun calc() {
        alreadyActivated = true
        outputvalue = when(operation) {
            "AND" -> input1value!! and input2value!!
            "OR" -> input1value!! or input2value!!
            "XOR" -> input1value!! xor input2value!!
            else -> 3
        }
    }

    override fun toString(): String {
        return "$input1value $operation $input2value:  $output = $outputvalue"
    }
}
