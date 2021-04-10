object UndergroundSystem : Problem.Medium(1396) {

    class UndergroundSystem {

        private val currentTravels = HashMap<Int, Pair<String, Int>>()
        private val destinationAverages = HashMap<String, Pair<Int, Int>>()

        fun checkIn(id: Int, stationName: String, t: Int) = apply {
            currentTravels[id] = stationName to t
        }

        fun checkOut(id: Int, stationName: String, t: Int) = apply {
            val entry = currentTravels.remove(id) ?: return this
            val key = getCorrectKey(entry.first, stationName)
            val averageAdd = destinationAverages.getOrDefault(key, 0 to 0)
            destinationAverages[key] = averageAdd.first + 1 to averageAdd.second + t - entry.second
        }


        private fun getCorrectKey(startStation: String, endStation: String): String =
                "$endStation:$startStation".run {
                    if (destinationAverages.containsKey(this)) this
                    else "$startStation:$endStation"
                }


        fun getAverageTime(startStation: String, endStation: String): Double = destinationAverages
                .getOrDefault(getCorrectKey(startStation, endStation), 0 to 0)
                .run { second.toDouble() / first.toDouble() }

    }

    override val testCases = arrayOf(UndergroundSystem())


    override fun runProblem() = buildString {
        val undergroundSystem = UndergroundSystem()
                .checkIn(45, "Leyton", 3)
                .checkIn(32, "Paradise", 8)
                .checkIn(27, "Leyton", 10)
                .checkOut(45, "Waterloo", 15)
                .checkOut(27, "Waterloo", 20)
                .checkOut(32, "Cambridge", 22)
        append("\nParadise - Cambridge ").appendLine(undergroundSystem.getAverageTime("Paradise", "Cambridge"))
        append("Leyton - Waterloo ").appendLine(undergroundSystem.getAverageTime("Leyton", "Waterloo"))
        undergroundSystem.checkIn(10, "Leyton", 24)
        append("Leyton - Waterloo ").appendLine(undergroundSystem.getAverageTime("Leyton", "Waterloo"))         // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38)
        append("Leyton - Waterloo ").appendLine(undergroundSystem.getAverageTime("Leyton", "Waterloo"))
    }
}