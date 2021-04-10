object SubdomainVisits : Problem.Easy(811) {

    private fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val map = HashMap<String, Int>()
        for (i in cpdomains) {
            var numIndex = 0
            var tempString = ""
            while (i[numIndex].isDigit()) {
                tempString += i[numIndex++]
            }
            val num = tempString.toInt()
            tempString = ""
            for (j in i.length - 1 downTo numIndex) {
                if (i[j] == '.' || j == numIndex) {
                    map[tempString] = map.getOrDefault(tempString, 0) + num
                }
                tempString = i[j] + tempString
            }
        }
        return map.entries.map { it.run { "$value $key" } }
    }

    override fun runProblem() = subdomainVisits(testCases[0])

    override val testCases = arrayOf(
        arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")
    )
}