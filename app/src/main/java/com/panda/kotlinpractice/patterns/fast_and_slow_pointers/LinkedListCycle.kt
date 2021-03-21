package com.panda.kotlinpractice.patterns.fast_and_slow_pointers

/*
Problem Statement #
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle
in it or not.
 */


//internal class ListNode(value: Int) {
//    var value = 0
//    var next: ListNode? = null
//
//    init {
//        this.value = value
//    }
//} // this above is also representation of the LinkedList but in java style

class ListNode(val value: Int,var next:ListNode?=null) // this is representation of the LinkedList

internal object LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast != null && fast.next!!.next != null){
            fast = fast.next!!.next
            slow = slow?.next
            if (fast == slow)
                return  true
        }
        return false
    }
}


fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)

    println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head))
    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next
    println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head))
    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next!!.next
    println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head))
}