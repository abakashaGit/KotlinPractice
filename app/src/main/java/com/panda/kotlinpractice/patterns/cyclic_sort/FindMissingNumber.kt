package com.panda.kotlinpractice.patterns.cyclic_sort

/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2
Example 2:

Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
 */
class FindMissingNumber {
    fun findTheMissingNumber(array: IntArray): Int {
        var i = 0
        while (i < array.size) {
            if (array[i] < array.size && array[i] != array[array[i]]) {
                swap(array, i, array[i])
            } else {
                i++
            }
        }
        for (v in array.indices) {
            if (v != array[v])
                return v
        }
        return array.size
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}

fun main() {
    println("missing number in 4, 0, 3, 1 is ${FindMissingNumber().findTheMissingNumber(intArrayOf(4, 0, 3, 1))}")
    println("missing number in 0,3,2  is ${FindMissingNumber().findTheMissingNumber(intArrayOf(0,3,2 ))}")
}