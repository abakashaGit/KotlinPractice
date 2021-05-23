package com.panda.kotlinpractice.patterns.cyclic_sort

class FindSmallestMissingNumber {

    companion object{
        fun find(arr : IntArray):Int{
            var i = 0
            while (i<arr.size){
                if (arr[i]>0 && arr[i] <= arr.size &&  arr[i] != arr[arr[i] - 1] ){
                    swap(arr,i,arr[i]-1)
                }else
                    i++
            }
            for ( k in arr.indices){
                if (arr[k] != k+1)
                    return k+1
            }
            return -1
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
}

fun main() {
    println(FindSmallestMissingNumber.find(intArrayOf(-3, 1, 5, 4, 2)))
    println(FindSmallestMissingNumber.find(intArrayOf(3, -2, 0, 1, 2)))
    println(FindSmallestMissingNumber.find(intArrayOf(3, 2, 5, 1)))
}