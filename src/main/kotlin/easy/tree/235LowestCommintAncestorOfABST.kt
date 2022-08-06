package easy.tree

import medium.tree.TreeNode
import medium.tree.isValidBSTMyAns

/**
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
        */

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    println("root ${root?.value}")
    println("p ${p?.value}")
    println("q ${q?.value}")

    if(root == null) {
        println("here0")
        return null
    }
    if(root.value == p!!.value){
        print("here1")
        println(root.value)
        return root
    }
    if(root.value == q!!.value) {
        print("here2")
        println(root.value)

        return root
    }
    if(root.value < p!!.value && root.value > q!!.value) {
        print("here3")
        println(root.value)

        return root
    }
    if(root.value < q!!.value && root.value > p!!.value) {
        print("here4")
        println(root.value)

        return root
    }
    if(root.value < p!!.value && root.value < q!!.value) {
        lowestCommonAncestor(root.right,p,q)
    }
   // if(root.value > p!!.value && root.value > q!!.value)
        return lowestCommonAncestor(root.left,p,q)
}

fun main(){

    val a =  TreeNode(value = 2)
    val b =  TreeNode(value = 4)
    val root = TreeNode(value = 6)
    root.left = a
    root.right = TreeNode(value = 8)
    root.left!!.left = TreeNode(value = 0)
    root.left!!.right = b
    print(lowestCommonAncestor(root,a,b)?.value)
}