package com.panda.kotlinpractice.patterns.cyclic_sort

class CyclicSort {



companion object{
    fun sort(nums: IntArray) {
        var i = 0
        while (i < nums.size) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1)
            else
                i++
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}

}

fun main() {
    var arr = intArrayOf(3, 1, 5, 4, 2)
    CyclicSort.sort(arr)
    for (num in arr) print("$num ")
    println()
    arr = intArrayOf(2, 6, 4, 3, 1, 5)
    CyclicSort.sort(arr)
    for (num in arr) print("$num ")
    println()
    arr = intArrayOf(1, 5, 6, 4, 3, 2)
    CyclicSort.sort(arr)
    for (num in arr) print("$num ")
    println()
}
