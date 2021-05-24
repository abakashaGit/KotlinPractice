package com.panda.kotlinpractice.patterns.cyclic_sort

class FindAllMissingNumbers {

    fun printAllMissingNumbers(array: IntArray) {
        var i = 0
        while (i < array.size) {
            if (array[i] != array[array[i] -1 ]) {
                swap(array, i, array[i] -1)
            } else {
                i++
            }
        }
        for (v in array.indices) {
            if (v+1 != array[v])
               println(v)
        }

    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}

fun main() {
    FindAllMissingNumbers().printAllMissingNumbers(intArrayOf(2, 3, 1, 8, 2, 3, 5, 1))
}