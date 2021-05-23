package com.panda.kotlinpractice.patterns.cyclic_sort

class FindDuplicateNumber {
    companion object This{
        fun findDuplicate(arr:IntArray):Int{
            var i =0
            while (i < arr.size){
                if (arr[i] != i+1){
                    if (arr[i] != arr[arr[i]-1])
                        swap(arr,i,arr[i]-1)
                    else
                        return arr[i]
                }
                else
                    i++
            }
            return -1;
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
}

fun main() {
    println(FindDuplicateNumber.findDuplicate(intArrayOf(1, 4, 4, 3, 2)))
    println(FindDuplicateNumber.findDuplicate(intArrayOf(2, 1, 3, 3, 5, 4)))
    println(FindDuplicateNumber.findDuplicate(intArrayOf(2, 4, 1, 4, 4)))
}