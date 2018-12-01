package lt.setkus.adventofcode2018

import java.io.File

fun MutableList<Int>.loadFromFile(path: String): MutableList<Int> {
    val file = this::javaClass.javaClass.classLoader.getResource(path).file
    return File(file).useLines { it.toList() }.map { it.toInt() }.toMutableList()
}