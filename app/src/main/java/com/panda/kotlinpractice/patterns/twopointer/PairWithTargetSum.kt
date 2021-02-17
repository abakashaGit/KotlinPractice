package com.panda.kotlinpractice.patterns.twopointer

/*
#### Problem Statement ###
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

 */

fun main() {
    val sortedInputArray = intArrayOf(11)
    val targetSum = 11
    var startPoint = 0
    var endpoint = sortedInputArray.size - 1
    var isFound = false

    while (startPoint <= endpoint){
        var sum = sortedInputArray[startPoint] + sortedInputArray[endpoint]
        if (sum == targetSum)
        {
            isFound = true
            println("The index of the numbers are $startPoint and $endpoint")
            break
        }
        if (sum > targetSum){
            endpoint--
        }else{
            startPoint++
        }
    }
    if (!isFound) println("There is no pairs in the array")
}
