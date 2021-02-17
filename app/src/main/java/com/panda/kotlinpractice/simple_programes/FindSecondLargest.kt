package com.panda.kotlinpractice.simple_programes

import java.util.*
import kotlin.math.max

/*
Given an array of unsorted elements, find the second highest number in the array
Input: arr[] = {12, 35, 1, 10, 34, 1}
Output: The second largest element is 34.
Explanation: The largest element of the
array is 35 and the second
largest element is 34

Input: arr[] = {10, 5, 10}
Output: The second largest element is 5.
Explanation: The largest element of
the array is 10 and the second
largest element is 5

Input: arr[] = {10, 10, 10}
Output: The second largest does not exist.
Explanation: Largest element of the array
is 10 there is no second largest element

 */

//############# SOLUTION ONE ################
private fun findSecondLargest(inputArray: Array<Int>) :Int?{
    val size = inputArray.size
    if (size < 2)
    {
        println("Invalid input")
        return null
    }
    Arrays.sort(inputArray)
    for (i in inputArray.lastIndex-1 downTo 0){
        if (inputArray[i] != inputArray[i+1])
            return inputArray[i]
    }
    return null
}
/*
The above logic is easy to implement but with complexity of O(nlogn) which is not efficient enough
 */

//############# SOLUTION TWO ################
/*
This is better then the first solution and finds output with complexity O(n)
 */
private fun findSecondLargest2(inputArray: Array<Int>):Int?{
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE
    if (inputArray.size < 2)
    {
        println("Invalid input")
        return null
    }
    for (element in inputArray)
    {
        largest = max(largest, element)
    }
    for (i in inputArray.indices)
    {
        if (inputArray[i] == largest)
            continue
        else
            secondLargest = max(secondLargest,inputArray[i])

    }

    return if (secondLargest == Int.MIN_VALUE) null else secondLargest
}

//############# SOLUTION THREE Efficient################
/*
This is the most efficient solution and works with just one loop with O(n) complexity
 */
private fun findSecondLargestEfficient(inputArray: Array<Int>):Int?{
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE
    if (inputArray.size < 2)
    {
        println("Invalid input")
        return null
    }
    for (i in inputArray.indices)
    {
        if (inputArray[i] > largest){
            secondLargest = largest
            largest = inputArray[i]
        }else if(inputArray[i] != largest && secondLargest < inputArray[i]){
            secondLargest = inputArray[i]
        }
    }

    return if (secondLargest == Int.MIN_VALUE) null else secondLargest
}

fun main() {
//    println(findSecondLargest(arrayOf(12, 35, 1, 10, 34, 1)))
//    println(findSecondLargest(arrayOf(10, 5, 10)))
//    println(findSecondLargest(arrayOf(10, 10, 10)))
//    println(findSecondLargest2(arrayOf(12, 12,12,16,22,13,17)))
    println(findSecondLargestEfficient(arrayOf(10,5,10)))
}