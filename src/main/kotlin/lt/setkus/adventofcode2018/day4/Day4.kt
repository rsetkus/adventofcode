package lt.setkus.adventofcode2018.day4

import java.lang.IllegalArgumentException

sealed class Event
class WakeUp: Event()
class Asleep: Event()
class ShiftChange: Event()

data class Record(
        val guardId: Int,
        val month: Int,
        val day: Int,
        val hour: Int,
        val minute: Int,
        val event: Event
)

data class GuardReport(val guardId: Int, val totalMinutes: Int, val mostMinuteAsleep: Int)

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

    private val mapToGuardReport: (List<Record>) -> GuardReport = {
        val periods = it.partition { it.event is Asleep }
        GuardReport(it.first().guardId, calculateTotalMinutes(periods), findMostMinuteAsleep(periods))
    }

    private val calculateTotalMinutes: (Pair<List<Record>, List<Record>>) -> Int = { periods ->
        periods.first.zip(periods.second).sumBy {
            it.second.minute - it.first.minute
        }
    }

    private val findMostMinuteAsleep: (Pair<List<Record>, List<Record>>) -> Int = { periods ->
        val asleepAndWakePeriods = periods.first.zip(periods.second)
        (0..59).maxBy { minute ->
            asleepAndWakePeriods.count {
                minute in (it.first.minute..it.second.minute)
            }
        } ?: -1
    }

    fun findGuard(): Int {
        val report = records
                .sorted()
                .map { mapToRecord(it) }
                .filter { it.event !is ShiftChange }
                .groupBy {
                    it.guardId
                }.map {
                    mapToGuardReport(it.value)
                }.sortedByDescending {
                    it.totalMinutes
                }.first()

        return report.guardId * report.mostMinuteAsleep
    }
}

private fun String.getGuardEvent(): Event {
    return when(this) {
        "falls asleep" -> Asleep()
        "wakes up" -> WakeUp()
        else -> ShiftChange()
    }
}