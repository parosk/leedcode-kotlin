package easy

import medium.ListNode


/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var node = head
    var prev: ListNode? = null
    var reversed: ListNode? = null
    while (node != null) {
        val next = node.next
        if (node.next == null) {
            reversed = node
        }
        node.next = prev
        prev = node
        node = next
    }
    return reversed
}

fun reverseListMyAns(head: ListNode?): ListNode? {

    val dummyHead = ListNode(0)
    var running = dummyHead
    fun reverseListAux(head: ListNode?){
        if(head == null){
            return
        }
        reverseListAux(head.next)
        running.next = ListNode(head.value)
        running = running.next!!
        //print(head.value)
//        running.next = head
//        running = running.next!!
    }

    reverseListAux(head)
    return dummyHead.next

}

fun main(){
    //val l1 = 0;
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(6)
    l1.next!!.next!!.next = ListNode(4)


    var startNode = reverseListMyAns(l1)

    while (startNode != null) {
        println(startNode.value)
        startNode = startNode.next
    }
}

