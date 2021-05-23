package com.panda.kotlinpractice.patterns.cyclic_sort

class FindCorruptPair {
    companion object {
        fun findCorruptPair(arr: IntArray): IntArray {

            var i = 0
            while (i < arr.size) {
                if (arr[i] != arr[arr[i] - 1]) {
                    swap(arr, i, arr[i] - 1)
                } else {
                    i++
                }
            }
            for(k in 0 .. arr.size-1)
            {
                print(" ${arr[k]}")
            }
            for(k in 0 .. arr.size-1)
            {
                if (k+1 != arr[k]){
                    print(" duplicate number is ${arr[k]} missing number is ${k+1}" )
                    return intArrayOf(arr[k],k+1)
                }
            }

            return intArrayOf(-1,-1)
        }

        private fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
}

fun main() {
    FindCorruptPair.findCorruptPair(intArrayOf(3, 1, 2, 5, 2,4,6))
    //FindCorruptPair.findCorruptPair(intArrayOf(3, 1, 2, 3, 6, 4))

}