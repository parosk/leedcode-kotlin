package easy

import java.util.*


/**
Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
fun longestPalindromeMyAns(s: String): Int {
    val letterMap = mutableMapOf<Char, Int>()
    for (char in s) {
        val oldCount = letterMap[char]
        letterMap[char] = if (oldCount != null) {
            oldCount + 1
        } else {
            1
        }
    }
    var length = 0
    var hasAddedOdd = false
    letterMap.values.forEach {
        val noOfPair = it / 2
        length += noOfPair * 2
        if (it % 2 == 1 && !hasAddedOdd) {
            length = length + 1
            hasAddedOdd = true
        }
    }
    return length
}

fun longestPalindromeSolution(s: String?): Int {
    if (s == null || s.length == 0) return 0
    val hs = HashSet<Char>()
    var count = 0
    for (i in 0 until s.length) {
        if (hs.contains(s[i])) {
            hs.remove(s[i])
            count++
        } else {
            hs.add(s[i])
        }
    }
    return if (!hs.isEmpty()) count * 2 + 1 else count * 2
}

fun main() {
    val s = "Aa"
    print(longestPalindromeMyAns(s))
}
