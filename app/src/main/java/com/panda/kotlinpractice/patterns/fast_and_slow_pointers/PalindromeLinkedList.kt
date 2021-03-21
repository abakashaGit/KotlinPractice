package com.panda.kotlinpractice.patterns.fast_and_slow_pointers

object PalindromeLinkedList {
    fun isPalindrome(head: ListNode): Boolean {
        var head : ListNode? = head
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next!!
            fast = fast.next!!.next!!
        }// now at this point we get to know the mid ListNode of the linkedList.
        // here slow is at the mid.
        // we need to reverse the linkedList from the slow node to the end
        // and store there in the linkedList itself to use constant space.
        var headSecondHalf = reverse(slow)
        var copyHeadSecondHalf = headSecondHalf
        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;
    }

    private fun reverse(head: ListNode?): ListNode? {
        var head: ListNode? = head
        var prev: ListNode? = null
        while (head != null) {
            val next = head.next
            head.next = prev
            prev = head
            head = next
        }
        return prev
    }

}

fun main() {
    val head = ListNode(2)
    head.next = ListNode(4)
    head.next!!.next = ListNode(6)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(2)
    // println("is Palindrome ${PalindromeLinkedList.isPalindrome(head)}")
    // head.next!!.next!!.next!!.next!!.next = ListNode(6)
    println("is Palindrome ${PalindromeLinkedList.isPalindrome(head)}")

}