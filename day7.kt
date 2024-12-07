import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    //var ops = arrayOf("+", "+", "+", "+")
    //val a = generateOperators(ops, 0, "+")
    //printGen(a)
    val sum = readFileLineByLine("inputs/test.txt", "A")
    println("Sum: " + sum)
}

fun readFileLineByLine(fileName: String, part: String): Long {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    var total: Long = 0
    File(fileName).inputStream().bufferedReader().forEachLine { 
        val values = it.split(" ")
        val target = values[0].substring(0, values[0].length - 1).toInt()
        val numbers = createMyArray(values.drop(1))
        println("$target, ${numbers}")
        val ops = Array(3){ "+" }
        val result = generateOperators(ops, 0, "+", target, numbers)
        println("Result $result")
    }       
    return total
}

fun createMyArray(numbers: List<String>): List<Int> {
    return numbers.map{ it.toInt() }
}

fun generateOperators(operators: Array<String>, index: Int, c: String, target: Int, numbers: List<Int>) {
    if(index > operators.size - 1) {
        operators.forEach { print(it) }
        println()
        val calc = calculate(target, numbers, operators)
        //print(calc)
        //return arrayListOf(operators)
        return
    }
    //var gen = arrayListOf<Array<String>>()
    var operators1 = operators
    operators1[index] = c
    //println("HERE $index, $c")
    generateOperators(operators1, index + 1, "+", target, numbers)
    generateOperators(operators1, index + 1, "*", target, numbers)
    //return gen
}

fun printGen(array: ArrayList<Array<String>>) {
    for(element in array) {
        for(el in element) {
            print(el)
        }
        println()
    }
}

fun calculate(target: Int, numbers: List<Int>, operations: Array<String>): Int {
    var value = numbers[0]
    //print("HERE   ")
    //operations.forEach{ print(it) }
    for(i in operations.indices) {
        if(operations[i] == "+") {
            value += numbers[i + 1]
        }
        if(operations[i] == "*") {
            value *= numbers[i + 1]
        }
    }
    //println(value)
    return if (value == target) value else 0
}