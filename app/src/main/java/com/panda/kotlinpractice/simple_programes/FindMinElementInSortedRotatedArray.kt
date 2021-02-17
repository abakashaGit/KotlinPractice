package com.panda.kotlinpractice.simple_programes

fun main() {
    val array = intArrayOf(6,1,2,3,4,5)
    val findMin = FindMin()
    println(findMin.findMinElement(array,0,array.size-1))
    findMin.printNumberOfLoop()
}
class FindMin {

    private var countLoops:Int = 0

    fun printNumberOfLoop(){
        println("number of loops is $countLoops")
    }

    fun findMinElement(inputArray: IntArray, l: Int, r:Int):Int{
        countLoops++

        if (l == r) return inputArray[l]

        if (inputArray[r] > inputArray[l])  return inputArray[0];// In this case the array is sorted so take the first element

        val mid = (r+l)/2
        if (mid < r && inputArray[mid] > inputArray[mid + 1])
            return inputArray[mid + 1]

        if (mid > l && inputArray[mid] < inputArray[mid - 1])
            return inputArray[mid]

        if (inputArray[r] > inputArray[mid])
            return findMinElement(inputArray, l, mid-1);
        return findMinElement(inputArray, mid+1, r);

    }

}
