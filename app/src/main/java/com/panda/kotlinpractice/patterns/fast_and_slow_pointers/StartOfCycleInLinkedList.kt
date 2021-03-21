package com.panda.kotlinpractice.patterns.fast_and_slow_pointers



object StartOfCycleInLinkedList {

    fun findCycleStart(head:ListNode):ListNode?{
        if (head == null)
            return null
        var slow :ListNode = head
        var fast :ListNode = head
        while (fast.next != null){
            slow = slow.next!!
            fast = fast.next!!.next!!
            if (slow == fast)
                break
        }
        var lengthOfCycle = findLengthOfTheCycle(slow)
        print("lentgh is $lengthOfCycle")
        slow = head
        fast = head
        while (lengthOfCycle > 0){
            fast = fast.next!!
            lengthOfCycle --
        }
        while (slow != fast){
            slow = slow.next!!
            fast = fast.next!!
        }
        return slow
    }
    private fun findLengthOfTheCycle(slow:ListNode):Int{
        var current = slow
        var count =0
        do {
            count ++
            current = current.next!!
        }while (current != slow)
        return count
    }
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)

    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next;
    System.out.println("LinkedList cycle start: " + StartOfCycleInLinkedList.findCycleStart(head)?.value);

    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next!!.next;
    System.out.println("LinkedList cycle start: " + StartOfCycleInLinkedList.findCycleStart(head)!!.value);

    head.next!!.next!!.next!!.next!!.next!!.next = head;
    System.out.println("LinkedList cycle start: " + StartOfCycleInLinkedList.findCycleStart(head)?.value);
}