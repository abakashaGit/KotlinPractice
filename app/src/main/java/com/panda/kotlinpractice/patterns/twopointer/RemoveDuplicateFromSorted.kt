package com.panda.kotlinpractice.patterns.twopointer

/*
Problem Statement #
Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates in-place return the length of
 the subarray that has no duplicate in it.


 */
class RemoveDuplicateFromSorted {

    fun remove(arr: IntArray): Int {
        if (arr.size == 1) return 1
        var nextNonDuplicate = 1
        for ( i in 1 until arr.size) {
            if (arr[nextNonDuplicate-1] != arr[i]){
                arr[nextNonDuplicate-1] = arr[i]
                nextNonDuplicate++
            }
        }
        return nextNonDuplicate
    }

    /*
    In the same way we can write one program to remove key from the unsorted array.
     */
    fun removeKeyFromUnsorted(inputArray: IntArray,key: Int):Int{
        var nextNonKeyElement = 0
        for (i in 0 until inputArray.size){
            if (inputArray[i] != key){
                inputArray[nextNonKeyElement++] = inputArray[i]
            }
        }

        for (j in 0 until nextNonKeyElement) print("  ${inputArray[j]}")
        return nextNonKeyElement
    }

}

fun main() {
    //println("Length of non duplicate array is ${RemoveDuplicateFromSorted().remove(intArrayOf(2, 3, 3, 3,4))}")

    println("\n Length of array without key is ${RemoveDuplicateFromSorted().removeKeyFromUnsorted(intArrayOf(3, 2, 3, 6, 3, 10, 9, 3),3)}")
}