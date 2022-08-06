package easy

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
 */
fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val maxC = image.first().size
    val maxR = image.size
    val oldColor = image[sr][sc]

    fun floodFillAux(r: Int, c: Int){

        if(r < 0 || r == maxR || c < 0 || c == maxC || image[r][c] != oldColor) return
        if(image[r][c] == oldColor){
            image[r][c] = color
        }
        floodFillAux(r + 1, c)
        floodFillAux(r - 1, c)
        floodFillAux(r , c + 1)
        floodFillAux(r , c - 1)
    }
    floodFillAux(sr,sc)
    return image
}