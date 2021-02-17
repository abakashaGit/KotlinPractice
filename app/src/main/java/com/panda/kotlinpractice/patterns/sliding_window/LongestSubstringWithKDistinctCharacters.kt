package com.panda.kotlinpractice.patterns.sliding_window

/*
Problem Statement #
Given a string, find the length of the longest substring in it with no more than K distinct characters.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

 */

private fun findLongestSubstring(inputString: String, k:Int):Int{
    var longestStr:Int = 0
    var windowStart = 0


    for (windowEnd in inputString.indices){

    }

    return longestStr
}
fun main() {
    findLongestSubstring("cbbebi",1)
}