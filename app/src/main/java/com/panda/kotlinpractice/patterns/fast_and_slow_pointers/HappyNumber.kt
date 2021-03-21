package com.panda.kotlinpractice.patterns.fast_and_slow_pointers

import kotlinx.coroutines.currentCoroutineContext

/*
Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:
2^2 + 3 ^2  = 4 + 9 = 13
1^2 + 3^2   = 1 + 9 = 10
1^2 + 0^2 ​​  = 1 + 0 = 1
 */


object HappyNumber {
    fun checkHappy(inputSum: Int):Boolean{
        //init a HashSet
        val set: MutableSet<Int> = HashSet()
        //get all digits in num and keep track of sum
        var curNum: Int = inputSum
        while (true) {
            var sum = 0
            while (curNum > 0) {
                val digit = curNum % 10
                sum += digit * digit
                curNum = curNum / 10
            }
            //if sum is 1 return true
            if (sum == 1) return true
            //check if sum is alreVady present in the set return false
            if (!set.add(sum)) return false
            //continue to find happy number
            curNum = sum
        }
    }

    fun checkHappyImproved(num : Int):Boolean{
        var slow = num
        var fast = num
        do {
            slow = findSquareSum(slow)
            fast = findSquareSum(findSquareSum(fast))

        }while (slow != fast)

        return slow == 1
    }
    private fun findSquareSum(value:Int):Int{
        var currentValue = value
        var currentSum = 0
        while (currentValue > 0){
            var digit = currentValue % 10
            currentSum += digit * digit
            currentValue /= 10
        }
        return currentSum
    }
}

fun main() {
    print("${HappyNumber.checkHappyImproved(12)} ")
}