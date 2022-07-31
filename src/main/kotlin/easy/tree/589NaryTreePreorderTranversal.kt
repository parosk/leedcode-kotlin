package easy.tree

import java.util.*


class NaryTreeNode(var value: Int) {
         var children: List<NaryTreeNode?> = listOf()
     }
//Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
// parent, then child
fun preorderMyAns(root: NaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun preOrderAux(root: NaryTreeNode?){
        if(root?.value!=null){
            result.add(root.value)
        }
        root?.children?.forEach {
            preOrderAux(it)
        }

    }
    preOrderAux(root)
    return result
}

    fun preorderIterative(root: NaryTreeNode?): List<Int> {

        // make use of stack
        var root: NaryTreeNode? = root
        val list: MutableList<Int> = ArrayList()
        if (root == null) return list
        val stack: Stack<NaryTreeNode> = Stack<NaryTreeNode>()
        stack.add(root)
        while (!stack.empty()) {
            root = stack.pop()
            list.add(root.value)
            for (i in root.children.size - 1 downTo 0) stack.add(root.children[i])
        }
        return list
    }


fun main(){
    val root = NaryTreeNode(1)
    root.children = listOf(NaryTreeNode(3),NaryTreeNode(2),NaryTreeNode(4))
    root.children.first()?.children = listOf(NaryTreeNode(5),NaryTreeNode(6))

    print(preorderMyAns(root))
}
