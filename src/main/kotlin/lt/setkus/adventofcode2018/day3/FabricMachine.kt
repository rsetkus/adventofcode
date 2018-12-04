package lt.setkus.adventofcode2018.day3

fun calculateOverlap(input: List<String>): Int {
    val fabric = Array(1000) {
        IntArray(1000)
    }

    input.map { mapInputToDrawingPair(it) }.forEach {
        drawOnFabric(fabric, it)
    }
    return fabric.asSequence().flatMap { it.asSequence() }.filter { it > 1 }.count()
}

val mapInputToDrawingPair = { input: String ->
    Pair(input.getDeltaXY(), input.getWidthAndHeight())
}

private fun drawOnFabric(fabric: Array<IntArray>, params: Pair<Pair<Int, Int>, Pair<Int, Int>>) {
    val deltaX = params.first.first
    val deltaY = params.first.second

    val width = params.second.first
    val height = params.second.second

    for (row in 0 until width) {
        for (column in 0 until height) {
            fabric[deltaX + row][deltaY + column]++
        }
    }
}

private fun String.getDeltaXY(): Pair<Int, Int> {
    val deltaXY = this.split(" ")[2].dropLast(1).split(",")
    return Pair(deltaXY[0].toInt(), deltaXY[1].toInt())
}

private fun String.getWidthAndHeight(): Pair<Int, Int> {
    val wh = this.split(" ")[3].split("x")
    return Pair(wh[0].toInt(), wh[1].toInt())
}