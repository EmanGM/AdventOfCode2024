import java.io.File
import java.io.InputStream

var trailheads: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()
var trails: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()
val MAP_SIZE = 40
var matrix: Array<Array<Int>> = Array(MAP_SIZE) {Array(MAP_SIZE) {-1} }
var rating = 0

fun main(args: Array<String>) {

    var robots = createRoomFromFile("inputs/test.txt")
    //printMatrix(map)
    var scores: Long = 0
    var rating_sum: Long = 0
    for(i in 0..10) {
        for(robot in robots) {
            robot.walk()
            //trails = mutableSetOf<Pair<Int, Int>>()
            //searchPath(map, trail.first, trail.second)
            //println("trails size: ${trails.size}, pat_two: $rating")
            //println()
        } 
    }
    //println("Score: $scores")
    //println("Ratings: $rating_sum")
}

fun createRoomFromFile(fileName: String): ArrayList<Robot> {

    var robots: ArrayList<Robot> = arrayListOf<Robot>()
    File(fileName).inputStream().bufferedReader().forEachLine { 
        val text = it.split(" ")
        val position = text[0].split(",")
        val velocity = text[1].split(",")
        val px = position[0].substring(2).toInt()
        val py = position[1].toInt()
        val vx = position[0].substring(2).toInt()
        val vy = position[1].toInt()
        robots.add(Robot(Pair(px, py), Pair(vx, vy)))
    }
    return robots
}

fun drawRoom(matrix: Array<Array<Int>>) {
    for(j in matrix.indices) {
        for(i in matrix[j].indices) {
            print("${matrix[j][i]} ")
        }
        println()
    }
}


class Robot(
    var position: Pair<Int, Int>,
    val velocity: Pair<Int, Int>,
) { 

    fun walk() {
        position = Pair(position.first + velocity.first, 
                        position.second + velocity.second)
    }
}