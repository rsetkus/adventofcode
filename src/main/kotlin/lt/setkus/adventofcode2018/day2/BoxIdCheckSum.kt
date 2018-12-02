package lt.setkus.adventofcode2018.day2

fun checkSum(input: List<String>): Int {
    val checkSum = input.asSequence()
            .map { it.asSequence().groupingBy { it }.eachCount() }
            .flatMap {
                it.values.distinct().asSequence()
            }
            .filter { it == 2 || it == 3 }
            .groupBy { it }
            .map {
                it.value.size
            }.reduce { acc, i -> acc * i }

    return checkSum
}

fun findCommonLetters(input: List<String>): String {
    var result = ""
     run loop@{
         input.forEach { outerIt ->
             input.forEach {
                 if (outerIt != it) {
                     val count = outerIt.zip(it).count {
                         it.first == it.second
                     }

                     if (outerIt.length - count == 1) {
                         outerIt.zip(it).forEach {
                             if (it.first == it.second) {
                                 result += it.first
                             }
                         }

                         return@loop
                     }
                 }
             }
         }
     }

    return result
}