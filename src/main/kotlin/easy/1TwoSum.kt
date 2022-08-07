package easy

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 */


fun twoSumMyAns(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int,Int>()
    var solution =intArrayOf()
    for(i in nums.indices){
        if(map[nums[i]] != null){
            solution = map[nums[i]]?.let { intArrayOf(it,i).sortedArray() }!!
            break
        }
        val diff = target - nums[i]
        map[diff] = i
    }
    return solution
}