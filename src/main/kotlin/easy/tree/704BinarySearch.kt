package easy.tree

fun searchSolution(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        if (nums[mid] == target) return mid else if (target > nums[mid]) low = mid + 1 else high = mid
    }
    return -1
}


fun searchMyAns(nums: IntArray, target: Int): Int {


    //print(nums.size)
    fun searchAux(target: Int, startIndex: Int, endIndex: Int): Int {
        println("startIndex${startIndex}")
        println("endIndex${endIndex}")
        if (startIndex == endIndex) {
            return if (nums[startIndex] == target) {
                startIndex
            } else {
                -1
            }
        } else {
            val middle = (endIndex + startIndex) / 2
            println("middle${middle}")
            return if (nums[middle] == target) {
                middle
            } else {
                if (nums[middle] > target) {
                    searchAux(target, startIndex, middle - 1)
                } else {
                    searchAux(target, middle + 1, endIndex)
                }
            }
        }


    }
    return searchAux(target, 0, nums.size - 1)
}

fun main() {
    val input = listOf(2, 5, 6)
    print(searchSolution(input.toIntArray(), 6))
}
