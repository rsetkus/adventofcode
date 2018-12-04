package lt.setkus.adventofcode2018.day3

data class Claim(val id: Int, val deltaX: Int, val deltaY: Int, val width: Int, val height: Int)

class Day3(val input: List<String>) {

    private val fabric = Array(1000) {
        IntArray(1000)
    }

    private val mapToClaim = { input: String ->
        val regex  = """#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""".toRegex()
        val match = regex.find(input)
        if (match != null) {
            val (id, dx, dy, w, h) = match.destructured
            Claim(id.toInt(), dx.toInt(), dy.toInt(), w.toInt(), h.toInt())
        } else {
            throw IllegalArgumentException("Cannot parse $input input")
        }
    }

    fun calculateOverlap(): Int {
        drawClaims()
        return fabric.asSequence().flatMap { it.asSequence() }.filter { it > 1 }.count()
    }

    private fun drawClaims() {
        input.map { mapToClaim(it) }.forEach {
            drawOnFabric(fabric, it)
        }
    }

    fun findNonOverlappingId(): Int {
        var claimId = -1;
        drawClaims()
        input.map { mapToClaim(it) }.forEach {
            var area = 0
            for (row in 0 until it.width) {
                for (column in 0 until it.height) {
                    area += fabric[it.deltaX + row][it.deltaY + column]
                }

                if (area == it.height * it.width) {
                    claimId = it.id
                    return@forEach
                }
            }
        }

        return claimId
    }

    private fun drawOnFabric(fabric: Array<IntArray>, claim: Claim) {
        for (row in 0 until claim.width) {
            for (column in 0 until claim.height) {
                fabric[claim.deltaX + row][claim.deltaY + column]++
            }
        }
    }
}