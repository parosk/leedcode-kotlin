package easy

import medium.ListNode
import medium.addTwoNumbersMyAns2

/**
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/


fun mergeTwoListsRecursive(list1: ListNode?, list2: ListNode?): ListNode? {
    //really smart way to do it recursively
    if(list1 == null) return list2
    if(list2 == null) return list1

    return if(list1.value <= list2.value){
        list1.next = mergeTwoListsRecursive(list1.next, list2)
        list1
    }else{
        list2.next = mergeTwoListsRecursive(list1, list2.next)
        list2
    }
}






fun mergeTwoListsMyAns(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var running = dummyHead
    var running1 = list1
    var running2 = list2
    while(running1 != null && running2 != null){
       if(running1.value <= running2.value){
           running.next = ListNode(running1.value)
           running1 = running1.next
       }else{
           running.next = ListNode(running2.value)
           running2 = running2.next
       }
        running = running.next!!
    }
    if(running1 == null){
        running.next = running2
    }
    if(running2 == null){
        running.next = running1
    }
    return dummyHead.next
}

fun main(){
    //val l1 = 0;
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(6)
    l1.next!!.next!!.next = ListNode(4)

    val l2 = ListNode(3)
    l2.next = ListNode(5)
    l2.next!!.next = ListNode(7)

    var startNode = mergeTwoListsRecursive(l1, l2)

    while (startNode != null) {
        println(startNode.value)
        startNode = startNode.next
    }
}