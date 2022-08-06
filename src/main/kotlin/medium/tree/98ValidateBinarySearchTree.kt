package medium.tree

/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

 */

fun isValidBSTSolution(node: TreeNode?): Boolean {
    return isValid(node, null, null)
}

private fun isValid(n: TreeNode?, min: Int?, max: Int?): Boolean {
    return n == null ||
            (min == null || n.value > min) && (max == null || n.value < max) &&
            isValid(n.left, min, n.value) && isValid(n.right, n.value, max)
}



fun isValidBSTMyAns(root: TreeNode?): Boolean {


    fun isValidAux(root: TreeNode?, max: Int?, min: Int?): Boolean {
        if (root?.left == null && root?.right == null) return true
        var isValid = true
        if (root.left != null) {
            isValid = isValid && root.left!!.value < root.value
        }
        if (root.right != null) {
            isValid = isValid && root.value < root.right!!.value
        }
        if (max != null) {
            isValid = isValid && ((root.right?.value ?: root.value) < max)
        }
        if (min != null) {
            isValid = isValid && (min < (root.left?.value ?: root.value))
        }
        return isValid && isValidAux(root.left, root.value, min) && isValidAux(root.right, max, root.value)
    }
    return isValidAux(root, null, null)
}

fun main() {
    val root = TreeNode(value = 9)
    root.left = TreeNode(value = 3)
    root.right = TreeNode(value = 20)
    print(isValidBSTMyAns(root))
}