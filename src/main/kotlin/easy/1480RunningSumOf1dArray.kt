package easy

fun runningSumMyAns(nums: IntArray): IntArray {
    var perv = 0
    for (i in nums.indices) {
        val old = nums[i]
        nums[i] = old + perv
        perv += old
    }
    return nums

}

fun runningSumSolution(nums: IntArray): IntArray {
    for (i in 1 until nums.size) {
        nums[i] = nums[i - 1] + nums[i]
    }
    return nums

}



fun main() {
    val input = intArrayOf(1, 2, 3, 4)
    print(runningSumSolution(input).contentToString())

}

