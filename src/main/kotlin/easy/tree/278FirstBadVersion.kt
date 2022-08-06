package easy.tree

/**
 * Suppose you have n versions [1, 2, ..., n]
 * and you want to find out the first bad one, which causes all the following ones to be bad.
 */

//Template for binary search

/**
 * def binary_search(array) -> int:
def condition(value) -> bool:
pass

left, right = 0, len(array) - 1
while left < right:
mid = left + (right - left) // 2
if condition(mid):
right = mid
else:
left = mid + 1
return left
 */
fun isBadVersion(version: Int) : Boolean {
    return version > 0
}

fun firstBadVersion(n: Int) : Int {
    var start = 1
    var end = n
    while (start < end) {
        // because if not do so, it will be overflow
        val mid = start + (end - start) / 2
        if (!isBadVersion(mid)) start = mid + 1 else end = mid
    }
    return start

}

fun main(){
    print(firstBadVersion(2))
}