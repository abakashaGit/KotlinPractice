package com.panda.kotlinpractice.patterns.sliding_window

import android.os.Build
import androidx.annotation.RequiresApi

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters, it will have n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Example 3:
Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
 */

private class PermutationOfAString {

//    fun checkPermutationPresent(inputString: String, pattern: String):Boolean{
//        var isPresent = false
//        if (pattern.length > inputString.length) return false
//        if (pattern.length == inputString.length){
//            //equals implementation
//        }
//        //one more case when all char of the pattern is same.
//        //In that case need to find the substring in the input string
//        val map:MutableMap<Char, Int> = mutableMapOf()
//        resetMap(map, pattern)
//
////        var startIndex = 0
////        var endIndex = startIndex + pattern.length -1 // pattern found from the start index to the end index
//        var counter = 0
//        for ( i in 0..inputString.length - pattern.length){
//            val char = inputString[i]
//            //println("char before condition $char")
//            if (map.containsKey(char) ){
//                //println("$map char is $char")
//                if (map[char] == 0) {
//                    map[char] = 1
//                    if (++counter == pattern.length)
//                        return true
//                }
//                else {
//                    counter = 0
////                    startIndex = i
////                    endIndex = startIndex + pattern.length -1
//                    resetMap(map, pattern)
//                }
//            }else{
//                counter = 0
////                startIndex = i
////                endIndex = startIndex + pattern.length -1
//                resetMap(map, pattern)
//               // println("index $i startIndex $startIndex endIndex $endIndex map = $map ")
//            }
//        }
//
//        return isPresent
//    }

//    private fun resetMap(map: MutableMap<Char, Int>, pattern: String) {
//        for (c in pattern)
//            map[c] = 0
//    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun findPermutation(str: String, pattern: String): Boolean {
        val patternCharCountMap: MutableMap<Char, Int?> = HashMap()
        for (c in pattern.toCharArray()) {
            patternCharCountMap[c] = patternCharCountMap.getOrDefault(c, 0)!! + 1
        }
        val curCharCountMap: MutableMap<Char, Int> = HashMap()
        var initialCharFound = false
        var leftIndex = 0
        for (pos in str.indices) {
            val c = str[pos] // get cur char

            //check if the cur char is present in the pattern
            if (patternCharCountMap.containsKey(c)) {
                // get count of this char seen so far
                val curCharCount = curCharCountMap.getOrDefault(c, 0) + 1
                if (curCharCount <= patternCharCountMap[c]!!) {
                    // make the left index point to first pattern char found
                    leftIndex = if (initialCharFound) leftIndex else pos
                    initialCharFound = true
                    curCharCountMap[c] = curCharCount
                } else {
                    // if the char doesnt match the count in pattern -
                    // reset countMap and make left point to cur pos
                    // and continue to check for a pattern again
                    leftIndex = pos
                    curCharCountMap.clear()
                    curCharCountMap[c] = 1
                }

                // if the window length matches the pattern length then we have found a pattern
                val curLen = pos - leftIndex + 1
                if (curLen == pattern.length) return true
            } else if (initialCharFound) { //if a char is found that doesn't belong to the pattern
                //reset the values
                leftIndex = 0
                initialCharFound = false
                curCharCountMap.clear()
            }
        }
        return false
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

//    println("oidbcaf, abc = ${PermutationOfAString().checkPermutationPresent("oidbcaf", "abc")}")
//    println("odicf, dc = ${PermutationOfAString().checkPermutationPresent("odicf", "dc")}")
//    println("bcdxabcdy, bcdyabcdx = ${PermutationOfAString().checkPermutationPresent("bcdxabcdy",
//        "bcdyabcdx")}")
//    println("aaacb, abc = ${PermutationOfAString().checkPermutationPresent("aaacb", "abc")}")
    println("oidbcaf, abc = ${PermutationOfAString().findPermutation("oidbcaf","abc")}")
}



