import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    val buyers = readFileLineByLine("inputs/day22.txt")    
    var sum: Long = 0
    for(b in buyers) {
        var secret: Long = b
        for(i in 1..2000) {
            secret = stepThree(stepTwo(stepOne(secret)))
        }
        sum += secret
        println(" $secret, sum: $sum")
    }

}

fun readFileLineByLine(fileName: String): ArrayList<Long> {

    var buyers: ArrayList<Long> = arrayListOf<Long>()
    File(fileName).inputStream().bufferedReader().forEachLine { 
        buyers.add(it.toLong())
    }
    return buyers
}


fun stepOne(secretOld: Long): Long {
    val value = secretOld * 64
    var secret = mix(value, secretOld)
    secret = prune(secret)
    return secret 
}

fun stepTwo(secretOld: Long): Long {
    val value = secretOld / 32
    var secret = mix(value, secretOld)
    secret = prune(secret)
    return secret
}

fun stepThree(secretOld: Long): Long {
    val value = secretOld * 2048
    var secret = mix(value, secretOld)
    secret = prune(secret)
    return secret 
}

fun mix(secret: Long, value: Long): Long {
    return secret xor value
}

fun prune(secret: Long): Long {
    return secret % 16777216
}