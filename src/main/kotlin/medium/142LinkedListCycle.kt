package medium

fun detectCycleMyAns(head: ListNode?): ListNode? {
    var runner = head
    val resultMap = mutableMapOf<ListNode,ListNode>()
    while (runner?.next != null){
        if(resultMap.containsKey(runner.next)) return runner.next
        resultMap[runner] = runner.next!!
       runner = runner.next
    }
    return null
}

fun main(){
    val l1 = ListNode(3)
    l1.next = ListNode(2)
    //l1.next!!.next = l1
   l1.next!!.next = ListNode(0)
    l1.next!!.next!!.next = ListNode(-4)
    l1.next!!.next!!.next!!.next = l1.next
    print(detectCycleMyAns(l1)?.value)
}