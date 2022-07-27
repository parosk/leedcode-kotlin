package easy



/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

fun isSubsequenceSolution(s: String, t: String): Boolean {

    val tChar = t.toCharArray()
    val sChar = s.toCharArray()
    var i = 0
    var j = 0
    while (i < sChar.size && j < tChar.size) {
        if (sChar[i] == tChar[j]) {
            i++
        }
        j++
    }
    return i == sChar.size
}
fun isSubsequenceMyAns(s: String, t: String): Boolean {
    var currentIndex = -1
    var runningIndex = 0
    val tChar = t.toCharArray()
    var sChar = s.toCharArray()
    var foundCount = 0;
    for (i in sChar.indices) {
        for (j in currentIndex + 1 until tChar.size) {
            runningIndex = j
            if (sChar[i] == tChar[j]) {
                currentIndex = j
                foundCount++
                break
            }
        }
        if (i < sChar.size - 1 && runningIndex == tChar.size - 1) return false
    }
    return foundCount == sChar.size
}

fun main() {
    val s = ""
    val t = "aaaaaa"
    print(isSubsequenceSolution(s, t))

}