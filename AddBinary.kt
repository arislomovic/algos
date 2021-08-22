object AddBinary : Problem.Easy(67) {
    fun addBinary(a: String, b: String): String? {
        val sb = StringBuilder()
        var aIndex = a.length - 1
        var bIndex = b.length - 1
        var carry = 0
        while (aIndex >= 0 || bIndex >= 0) {
            var sum = carry
            if (bIndex >= 0) sum += b[bIndex--] - '0'
            if (aIndex >= 0) sum += a[aIndex--] - '0'
            sb.append(sum % 2) //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2 //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithmetic
        }
        if (carry != 0) sb.append(carry)
        return sb.reverse().toString()
    }
}
