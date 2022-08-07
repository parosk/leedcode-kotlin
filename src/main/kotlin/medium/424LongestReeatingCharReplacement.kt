package medium

/**
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 */
fun characterReplacementSolution(s: String, k: Int): Int {
    val charCount = IntArray(size = 26)

    var left = 0
    var right = 0

    var replacements = 0
    var maxCharacter = Int.MIN_VALUE
    var max = Int.MIN_VALUE

    while (left <= right && right <= s.lastIndex) {
        // Calculate the windowSize, adding 1 as our array starts from 0.
        val windowSize = right - left + 1

        // Collect left and right digit to be used later.
        // The - 'A' will ensure we are inside the 26 indices of our array.
        val leftDigit = s[left] - 'A'
        val rightDigit = s[right] - 'A'

        // Each time we find a character, we will include +1 to the count.
        charCount[rightDigit] += 1

        // We will keep the max number of same character we found during the loop.
        maxCharacter = maxOf(maxCharacter, charCount[rightDigit])

        // To calculate the number of replacements, we will reduce windowSize to the maxCharacter.
        // If your current window is 5 and we have 4 A, the number of replacements is 1.
        replacements = windowSize - maxCharacter

        if (replacements <= k) {
            // We keep the biggest windowSize - it is our result.
            max = maxOf(max, windowSize)
        } else {
            // If we passed our limit k, we should move left++ and reduce the
            // current count of left in 1.
            charCount[leftDigit] -= 1
            left++
        }

        // It is safe to keep moving right forward as we will always respect the constraints.
        right++
    }
    return max
}

fun main(){
    print(characterReplacementSolution("AAAAB",0))
}