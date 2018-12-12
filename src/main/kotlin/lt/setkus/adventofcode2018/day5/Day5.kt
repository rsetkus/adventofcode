package lt.setkus.adventofcode2018.day5

import kotlin.math.absoluteValue

private const val CAPITAL_AND_LOWER_CHAR_DIF = 32

class Day5(var polymer: String) {

    fun removeOppositePolarity() = analyze(polymer)

    fun analyze(input: String): String {
        var collector = input
        input.forEachIndexed { index, c ->
            val isOpposite = input.isPolarityOppositeAt(index)
            if (isOpposite) {
                val removed = input.removeRange(index, index + 2)
                collector = analyze(removed)
            }
        }

        return collector
    }
}

fun String.isPolarityOppositeAt(position: Int): Boolean {
    if (position == this.length - 1) {
        return false
    }
    return (this[position] - this[position + 1]).absoluteValue == CAPITAL_AND_LOWER_CHAR_DIF
}