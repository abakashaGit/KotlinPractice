package com.panda.kotlinpractice.patterns.sliding_window

/*
Problem Statement #
Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

 */

class SmallestSubArrayWithGivenSum {

    companion object {
        fun findSmallestSubArray(input: Array<Int>, s: Int):Int{
            var windowSum = 0
            var minLength = Int.MAX_VALUE
            var windowStart = 0

            for(windowEnd in 0..input.size-1){
                windowSum += input[windowEnd] // add the next element
                while (windowSum >= s){ // shrink the window from the left as much as possible to get the min length of the sub array
                    println("inside while when windowEnd is $windowEnd")
                    minLength = Math.min(minLength,windowEnd-windowStart+1)
                    windowSum = windowSum - input[windowStart] // subtract the element going out of window
                    windowStart++ // slide the window ahead

                }
            }

            return if (minLength == Int.MAX_VALUE)0 else minLength
        }
    }


}

fun main() {
    println(SmallestSubArrayWithGivenSum.findSmallestSubArray(arrayOf(3, 4, 1, 1, 6), 3))
}