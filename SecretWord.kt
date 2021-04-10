object SecretWord : Problem.Hard(843) {

    private fun findSecretWord(wordlist: Array<String>, master: Master) {
        val words = wordlist.mapTo(ArrayList()) { word ->
            word to wordlist.count { word.countIndexed { c, Index -> it[Index] == c } == 0 }
        }
        var matches = 0
        while (matches != 6) {
            val next = words.minByOrNull { it.second }?.first ?: continue
            matches = master.guess(next)
            words.removeIf { next.countIndexed { c, Index -> it.first[Index] == c } != matches }
        }
    }

    private fun findSecretWord(master: Master) = findSecretWord(master.words, master)
    override val mainTestcase get() = testCases[2]
    override fun runProblem() = findSecretWord(mainTestcase)
    override val testCases = arrayOf(
        Master(words = arrayOf("ccbazz", "eiowzz", "abcczz", "acckzz")),
        Master(arrayOf("hamada", "khaled")),
        Master(
            secret = "ccoyyo",
            words = arrayOf(
                "wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg", "trbzyb",
                "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro",
                "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg",
                "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp",
                "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd",
                "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc",
                "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm",
                "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb",
                "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf",
                "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq"
            )
        ),
    )
}