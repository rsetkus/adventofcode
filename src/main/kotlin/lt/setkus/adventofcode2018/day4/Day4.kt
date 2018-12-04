package lt.setkus.adventofcode2018.day4

import java.lang.IllegalArgumentException

data class Record(
        val month: Int,
        val day: Int,
        val hour: Int,
        val minute: Int,
        val event: String
)

class Day4(val records: List<String>) {

    val mapToRecord = { record: String ->
        val regex = """\[1518-(\d+)-(\d+) (\d+):(\d+)] (\w+)""".toRegex()
        val match = regex.find(record)
        match?.let {
            val (month, day, hour, minute, event) = it.destructured
            Record(month.toInt(), day.toInt(), hour.toInt(), minute.toInt(), event)
        } ?: throw IllegalArgumentException("cannot parse $record record")
    }

    fun findGuard(): Int {
        records.map { mapToRecord(it) }.forEach { println(it) }
        return 0
    }
}