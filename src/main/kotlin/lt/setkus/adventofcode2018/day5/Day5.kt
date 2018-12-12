package lt.setkus.adventofcode2018.day5

import kotlin.math.absoluteValue

private const val CAPITAL_AND_LOWER_CHAR_DIF = 32

class Day5(private val polymer: String) {

    fun removeOppositePolarity(): String {
        var collector = polymer
        do {
            val lengthBefore = collector.length
            for (index in 0 until collector.length) {
                val isOpposite = collector.isPolarityOppositeAt(index)
                if (isOpposite) {
                    collector = collector.removeRange(index, index + 2)
                    break
                }
            }
        } while (collector.length < lengthBefore)

        return collector
    }
}

fun String.isPolarityOppositeAt(position: Int): Boolean {
    if (position == this.length - 1) {
        return false
    }
    return (this[position] - this[position + 1]).absoluteValue == CAPITAL_AND_LOWER_CHAR_DIF
}