package com.panda.kotlinpractice.patterns.twopointer

import java.util.*

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

 */

class TripletSumToZero {
    fun searchTriplets(arr: IntArray): MutableList<IntArray> {
        var triplets : MutableList<IntArray> = mutableListOf<IntArray>()
        Arrays.sort(arr)

        for (i in 0..arr.size-2){
            if (i>0 && arr[i] == arr[i - 1])
                continue
            searchPairs(arr, -arr[i], i + 1, triplets)
        }
        return triplets
    }
    private fun searchPairs(
        arr: IntArray,
        targetSum: Int,
        left: Int,
        triplets: MutableList<IntArray>
    ){
        var right = arr.size -1
        var mLeft = left
        println("target sum $targetSum left $left right $right")
        while (mLeft < right){
            val currentSum = arr[mLeft] + arr[right]
            if (currentSum == targetSum){ // found a pair
                triplets.add(intArrayOf(-currentSum, arr[mLeft], arr[right]))
                mLeft++
                right--
                while (mLeft < right && arr[mLeft] == arr[mLeft - 1]) // skip the duplicate pairs from the left
                        mLeft++

                while (mLeft < right && arr[right] == arr[right + 1]) // skip the duplicate pairs from the right
                    right--
            }else if(currentSum > targetSum){
                right--
            }else{
                mLeft++
            }
        }

    }
}

fun main() {
    var output : MutableList<IntArray> = TripletSumToZero().searchTriplets(intArrayOf(-3, 0, 1, 2, -1, 1, -2))
    for (i in output){
        for ( j in i){
            print(" $j")
        }
        println(" ")
    }
    println()
    //println(TripletSumToZero().searchTriplets(intArrayOf(-5, 2, -1, -2, 3)))


}