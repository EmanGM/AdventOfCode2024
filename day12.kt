import java.io.File
import java.io.InputStream

var trailheads: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()
var trails: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()
val MAP_SIZE = 40
var rating = 0

var area = 1
var perimeter = 0
var explored: MutableSet<Pair<Int, Int>> = mutableSetOf<Pair<Int, Int>>()
var totalCost = 0

fun main(args: Array<String>) {

    val map = createMapFromFile("inputs/day10.txt")
    printMatrix(map)
    var scores: Long = 0
    var rating_sum: Long = 0
    for(trail in trailheads) {
        trails = mutableSetOf<Pair<Int, Int>>()
        searchPath(map, trail.first, trail.second)
        //println("trails size: ${trails.size}, pat_two: $rating")
        scores += trails.size
        rating_sum += rating
        rating = 0
        //println()
    }
    println("Score: $scores")
    println("Ratings: $rating_sum")
}

fun createGardenFromFile(fileName: String): Array<Array<Char>> {

    var matrix: Array<Array<Int>> = Array(MAP_SIZE) {Array(MAP_SIZE) {-1} }
    var lineNumber = 0
    File(fileName).inputStream().bufferedReader().forEachLine { 
        for(i in it.indices) {
            val height: Int = it[i].digitToInt()
            matrix[lineNumber][i] = height
            if(height == 0) {
                trailheads.add(Pair(lineNumber, i))
            }
        }
        lineNumber++
    }
    return matrix
}

fun printMatrix(matrix: Array<Array<Int>>) {
    for(j in matrix.indices) {
        for(i in matrix[j].indices) {
            print("${matrix[j][i]} ")
        }
        println()
    }
}

fun findRegion(character: Char, map: Array<Array<Int>>, y: Int, x: Int) {
    if(map[y][x] != character) {
        perimeter++
        trails.add(Pair(y, x))
        //println("Haha (${y},${x})")
        return 
    }
    //println("searching (${y},${x}) ${map[y][x]}")
    if(y + 1 < MAP_SIZE && map[y + 1][x] == (map[y][x])) {
        area++
        searchPath(map, y + 1, x)
    } 
    if(y - 1 >= 0 &&  map[y - 1][x] == (map[y][x])) {
        area++
        searchPath(map, y - 1, x)
    } 
    if(x + 1 < MAP_SIZE &&  map[y][x + 1] == (map[y][x])) {
        area++
        searchPath(map, y, x + 1)
    } 
    if(x - 1 >= 0 &&  map[y][x - 1] == (map[y][x])) {
        area++
        searchPath(map, y, x - 1)
    } 
}