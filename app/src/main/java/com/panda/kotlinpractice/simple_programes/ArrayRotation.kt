package com.panda.kotlinpractice.simple_programes



fun main() {
 rotate(intArrayOf(1, 2, 3, 4),4)
}

fun rotate(nums: IntArray, k: Int): Unit {
    var start = k
    require(!(nums == null || nums.size === 0 || start < 0)) { "Illegal argument!" }

    if (start > nums.size) {
        start = start % nums.size
    }

    //length of first part
    val a: Int = nums.size - start

    reverse(nums, 0, a - 1)
    reverse(nums, a, nums.size - 1)
    reverse(nums, 0, nums.size - 1)
    nums.forEach { print(" $it") }

}
fun reverse(nums:IntArray,l:Int,r:Int){
    if (nums == null || nums.size == 1)
        return
    var left = l
    var right = r
    while (left<right){
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        left++
        right--
    }

}
//fun rotate(nums: IntArray, k: Int): Unit {
//
//    var start = k
//    if (start > nums.size) start = start % nums.size
//
//    val result = IntArray(nums.size)
//
//    for (i in 0 until start) {
//        result[i] = nums[nums.size - start + i]
//    }
//
//    var j = 0
//    for (i in start until nums.size) {
//        result[i] = nums[j]
//        j++
//    }
//
//    result.forEach { print(" $it") }
//}
