package medium

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


 */
fun numIslands(grid: Array<CharArray>): Int {
  val maxR = grid.size
    val maxC = grid.first().size
    var numOfIsland = 0
    //val visited = Array(maxR) { BooleanArray(maxC) { false } }
    fun floodFillAux(r: Int, c: Int){
        if(r < 0 || r == maxR || c < 0 || c == maxC || grid[r][c] != '1') return
        grid[r][c] = '0'
        floodFillAux(r + 1, c)
        floodFillAux(r - 1, c)
        floodFillAux(r , c + 1)
        floodFillAux(r , c - 1)
    }

    for (i in 0 until maxR) {
        for (j in 0 until maxC) {
            if(grid[i][j] == '1'){
                floodFillAux(i,j)
                numOfIsland++
            }
        }
    }
    return numOfIsland
}