package lt.setkus.adventofcode2018

import java.io.File

fun MutableList<Int>.loadFromFile(path: String): MutableList<Int> {
    val file = this::javaClass.javaClass.classLoader.getResource(path).file
    return File(file).useLines { it.toList() }.map { it.toInt() }.toMutableList()
}

fun File.readFileToList(): MutableList<String> {
    val file = this::javaClass.javaClass.classLoader.getResource(path).file
    return File(file).useLines { it.toMutableList() }
}

fun Array<IntArray>.printMatrix() {
    for (row in 0 until this.size) {
        for (column in 0 until this[row].size) {
            print(" ${this[row][column]} ")
        }
        println()
    }
}