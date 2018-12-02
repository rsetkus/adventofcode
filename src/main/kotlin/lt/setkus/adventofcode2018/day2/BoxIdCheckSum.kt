package lt.setkus.adventofcode2018.day2

fun checkSum(input: List<String>): Int {
    val checkSum = input.asSequence()
            .map { it.asSequence().groupingBy { it }.eachCount() }
            .map {
                it.values.distinct()
            }
            .flatMap {
                it.asSequence()
            }
            .filter { it == 2 || it == 3 }
            .groupBy { it }
            .map {
                it.value.size
            }.reduce { acc, i -> acc * i }

    return checkSum
}