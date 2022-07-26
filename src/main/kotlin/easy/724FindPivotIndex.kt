package easy

fun pivotIndexSolution(nums: IntArray): Int {
    val totalSum = nums.sum()
    var leftSum = 0
    for(i in nums.indices){
        if(leftSum == totalSum - leftSum - nums[i]){
            return i
        }
        leftSum += nums[i]
    }
    return -1
}
fun main() {
    val input = intArrayOf(1, 3, 3, 4)
    print(pivotIndexSolution(input))

}