package lt.setkus.adventofcode2018.day1

fun frequencyResult(input: Array<Int>) = input.asSequence().sum()

fun duplicateFrequencyResult(input: Array<Int>): Int {
    val accumulator = mutableListOf(0)
    var sum = 0
    return generateSequence { input.asIterable() }
            .take(200) // repeat array 200 times
            .flatten()
            .map {
                sum += it
                accumulator.add(sum)
                sum

            }.filter { outerIt ->
                accumulator.filter { it == outerIt}.count() > 1
            }.first()
}