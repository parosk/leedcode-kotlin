package medium.tree

import com.sun.source.tree.Tree
import java.util.*

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val numQueue: Queue<TreeNode> = LinkedList()
    var nodeInThisLevel = 0
    if(root == null) return listOf()

    val result : MutableList<List<Int>> = mutableListOf()

    numQueue.add(root)
    nodeInThisLevel = 1
    while (numQueue.isNotEmpty() && nodeInThisLevel != 0){
        var nodeInNextLevel = 0
        val levelResult = mutableListOf<Int>()
        for(i in 0 until nodeInThisLevel){
            val current = numQueue.remove()
            levelResult.add(current.value)
            current.left?.let {
                numQueue.add(it)
                nodeInNextLevel++
            }
            current.right?.let {
                numQueue.add(it)
                nodeInNextLevel++
            }

        }
        result.add(levelResult)
        nodeInThisLevel = nodeInNextLevel

    }
    return result
}

fun main(){
   // val root = null
    val root = TreeNode(value = 3)
    root.left = TreeNode(value = 9)
    root.right = TreeNode(value = 20)
    root.right?.left = TreeNode(value = 15)
    root.right?.right = TreeNode(value = 7)

    print(levelOrder(root))
}
