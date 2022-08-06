package easy

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */

fun minCostClimbingStairsSolution(cost: IntArray): Int {
    for (i in cost.size - 3 downTo 0) {
        cost[i] += Math.min(cost[i + 1], cost[i + 2])
    }
    return Math.min(cost[0], cost[1])
}



fun minCostClimbingStairsMyAns(cost: IntArray): Int {
    var current = 0
    var totalCost = cost[0]
    while(current<cost.size-2){
        if(cost[current+1]< cost[current+2]){
            totalCost = totalCost + cost[current+1]
            current = current+1
        }else{
            totalCost = totalCost + cost[current+2]
            current = current+2
        }
    }

    var current1 = 1
    var totalCost1 = cost[1]
    while(current1<cost.size-2){
        if(cost[current1+1]< cost[current1+2]){
            totalCost1 = totalCost1 + cost[current1+1]
            current1 = current1+1
        }else{
            totalCost1 = totalCost1 + cost[current1+2]
            current1 = current1+2
        }
    }

    return if(totalCost <= totalCost1)totalCost else totalCost1
}

fun main() {
    print(minCostClimbingStairsSolution(intArrayOf(0,1,2,2)))
}