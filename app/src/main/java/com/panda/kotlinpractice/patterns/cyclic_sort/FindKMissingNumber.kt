package com.panda.kotlinpractice.patterns.cyclic_sort

class FindKMissingNumber {
    companion object
    {
        fun findNumbers(nums: IntArray, k: Int): List<Int> {
            var i = 0
            while (i < nums.size) {
                if (nums[i] > 0 && nums[i] <= nums.size && nums[i] != nums[nums[i] - 1]) swap(
                    nums,
                    i,
                    nums[i] - 1
                ) else i++
            }
            val missingNumbers: MutableList<Int> = ArrayList()
            val extraNumbers: MutableSet<Int> = HashSet()
            i = 0
            while (i < nums.size && missingNumbers.size < k) {
                if (nums[i] != i + 1) {
                    missingNumbers.add(i + 1)
                    extraNumbers.add(nums[i])
                }
                i++
            }

            // add the remaining missing numbers
            i = 1
            while (missingNumbers.size < k) {
                val candidateNumber = i + nums.size
                // ignore if the array contains the candidate number
                if (!extraNumbers.contains(candidateNumber))
                    missingNumbers.add(candidateNumber)
                i++
            }
            return missingNumbers
        }
        private fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
}

fun main() {
    val list1= FindKMissingNumber.findNumbers(intArrayOf(3, -1, 4, 5, 5),3)
    for (l in list1)
        print(" $l")
}