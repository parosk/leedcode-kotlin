package medium
import kotlin.math.pow

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun addTwoNumbersSolution(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    // create dummy head and return its next
    val dummyHead = ListNode(0)
    var curr: ListNode? = dummyHead
    var carry = 0
    // while carry at top
    while (l1 != null || l2 != null || carry != 0) {

        // set 0 if null to avoid the when cause
        val x = l1?.value ?: 0
        val y = l2?.value ?: 0
        val sum = carry + x + y
        carry = sum / 10
        curr!!.next = ListNode(sum % 10)
        curr = curr.next
        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next
    }
    return dummyHead.next
}

fun addTwoNumbersMyAns(l1: ListNode?, l2: ListNode?): ListNode? {
    var startingNode: ListNode? = null
    var runningNode: ListNode? = null
    var carryOver = 0

    var runningL1 = l1
    var runningL2 = l2

    while (runningL1 != null || runningL2 != null) {
        val sum = when {
            runningL1 == null -> {
                runningL2!!.value + carryOver
            }
            runningL2 == null -> {
                runningL1.value + carryOver
            }
            else -> {
                runningL1.value + runningL2.value + carryOver
            }

        }

        val remainder = sum % 10

        carryOver = sum / 10

        if (startingNode == null) {
            startingNode = ListNode(remainder)
            runningNode = startingNode
        } else {
            runningNode!!.next = ListNode(remainder)
            runningNode = runningNode!!.next
        }
        runningL1 = runningL1?.next
        runningL2 = runningL2?.next


    }
    if (carryOver != 0) {
        runningNode?.next = ListNode(carryOver)
    }
    return startingNode
}

fun addTwoNumbersMyAns2(l1: ListNode?, l2: ListNode?): ListNode? {
  // some how dont work
    val dummyHead = ListNode(0)
    var running = dummyHead
    var runningL1 = l1
    var runningL2 = l2

    var sum1 = 0
    var offset1 = 0
    var sum2 = 0
    var offset2 = 0
    while (runningL1 != null) {
        //print(runningL1.value * 10.0.pow(offset1.toDouble()).toInt())
        sum1 += runningL1.value * 10.0.pow(offset1.toDouble()).toInt()
        runningL1 = runningL1.next
        offset1 += 1
    }
    //print(sum1)
    while (runningL2 != null) {
        sum2 = sum2 + runningL2.value * 10.0.pow(offset2.toDouble()).toInt()
        runningL2 = runningL2.next
        offset2 += 1
    }

    var total = sum1 + sum2

    do {
        running.next = ListNode(total % 10)
        running = running.next!!
        total /= 10
    } while (total > 0)
    return dummyHead.next

}

fun main() {
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)
    //l1.next!!.next!!.next = ListNode(4)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)
    //l2.next!!.next!!.next = ListNode(4)

    var startNode = addTwoNumbersMyAns2(l1, l2)

    while (startNode != null) {
        println(startNode.value)
        startNode = startNode.next
    }
}