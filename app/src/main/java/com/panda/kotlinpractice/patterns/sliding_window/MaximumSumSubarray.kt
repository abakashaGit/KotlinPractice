package com.panda.kotlinpractice.patterns.sliding_window

/*
Problem Statement #
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
 */


private fun findMaximumSumSubarray(input: Array<Int>, k : Int):Int{
    var maxSum:Int = 0
    var sumOfWindow:Int = 0
    var startIndex:Int = 0

    for(i in 0..input.size -1){
        sumOfWindow += input[i] // add the next element
        println("after sum $sumOfWindow")

        if (i >= k-1){ // we dont need to slide until we reach the required size of the sub array
            maxSum = Math.max(maxSum,sumOfWindow) //save the max value of the sum of k sized sub array
            sumOfWindow = sumOfWindow - input[startIndex] // shrink the window from the left
            println(" $maxSum")
            startIndex++
        }
    }
    return maxSum
}
/*
Time Complexity #
The time complexity of the above algorithm will be O(N)O(N).

Space Complexity #
The algorithm runs in constant space O(1)O(1).
Brute force approach for this will take n*n time.
 */
fun main() {
    print(findMaximumSumSubarray(arrayOf(2, 3, 4, 1, 5),1))
}
