package lt.setkus.adventofcode2019.day2

class TwelveOTwoProgramAlarm(private val sequence: Array<Int>) {

    fun executeIntcode(): Int {
        var index = 0
        var opcode = sequence[0]
        execution@ while (index + 4 <= sequence.size) {
            when (opcode) {
                1 -> writeOut(sequence[sequence[index + 1]] + sequence[sequence[index + 2]], sequence[index + 3])
                2 -> writeOut(sequence[sequence[index + 1]] * sequence[sequence[index + 2]], sequence[index + 3])
                99 -> break@execution
            }
            index += 4
            opcode = sequence[index]
        }

        return sequence[0]
    }

    fun restore() {
        sequence[1] = 12
        sequence[2] = 2
    }

    private fun writeOut(value: Int, position: Int) {
        sequence[position] = value
    }
}
