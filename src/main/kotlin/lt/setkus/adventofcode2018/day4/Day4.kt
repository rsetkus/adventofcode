package lt.setkus.adventofcode2018.day4

import java.lang.IllegalArgumentException

data class Record(
        val guardId: Int?,
        val month: Int,
        val day: Int,
        val hour: Int,
        val minute: Int,
        val event: Int
)

class Day4(val records: List<String>) {

    private var guardId: Int = 0

    private val mapToRecord = { record: String ->
        val regex = """\[1518-(\d+)-(\d+) (\d+):(\d+)](.*)$""".toRegex()
        val match = regex.find(record)
        match?.let {
            val (month, day, hour, minute, event) = it.destructured
            guardId = getGuardId(event)
            Record(guardId, month.toInt(), day.toInt(), hour.toInt(), minute.toInt(), event.trim().getGuardEvent())
        } ?: throw IllegalArgumentException("cannot parse $record record")
    }

    private fun getGuardId(event: String): Int {
        return """(\d+)""".toRegex().find(event)?.value?.toInt() ?: guardId
    }

    fun findGuard(): Int {
        records.sorted().map { mapToRecord(it) }.forEach { println(it) }
        return 0
    }
}

private fun String.getGuardEvent(): Int {
    return when(this) {
        "falls asleep" -> 1
        else -> 0
    }
}