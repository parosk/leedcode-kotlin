package easy

import medium.ListNode

fun middleNodeMyAns(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while(fast?.next != null){
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}

fun main(){
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)
    l1.next!!.next!!.next = ListNode(4)
//    l1.next!!.next!!.next!!.next = ListNode(5)
//    l1.next!!.next!!.next!!.next!! = ListNode(6)
    print(middleNodeMyAns(l1)?.value)
}
