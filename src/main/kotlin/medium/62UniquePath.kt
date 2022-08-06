package medium

/**
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
        */
fun uniquePathsAns(m: Int, n: Int): Int {
    val arr = Array(m) { IntArray(n) }

    for(i in 0 until m){
        for(j in 0 until n){
            if(i == 0 || j == 0){
                arr[i][j] = 1
            }else{
                arr[i][j] =  arr[i- 1][j] + arr[i][j-1]
            }
        }
    }

    return arr[m-1][n-1]


}




fun uniquePathsMath(m: Int, n: Int): Int {
    // by combination
   val length = m + n - 2
    var running = length
    val max = Math.max(m-1, n -1)
    val min = Math.min(m-1, n -1)
    var top = 1L
    while(running > max){
        top = top * running
        running = running - 1
    }

    var bottom = 1L
    var running2 = 1
    while (running2 <= min){
        bottom = bottom * running2
        running2  = running2 + 1
    }
    //print(top)

    return (top.toDouble() / bottom.toDouble()).toInt()


}

fun main(){
    print(uniquePathsAns(3,7))
}