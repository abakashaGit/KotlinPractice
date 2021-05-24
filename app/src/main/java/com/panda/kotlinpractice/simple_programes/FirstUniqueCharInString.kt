package com.panda.kotlinpractice.simple_programes

import android.os.Build
import androidx.annotation.RequiresApi

class FirstUniqueCharInString {
    @RequiresApi(Build.VERSION_CODES.N)
    fun findUniqueChar(inputString:String):Int{
        val charMap:MutableMap<Char,Int> = mutableMapOf()
        for (c in inputString){
            charMap[c] = charMap.getOrDefault(c,0) + 1
        }
        for (key in charMap.keys){
            if (charMap[key] == 1)
                return inputString.indexOf(key)
        }
        return -1
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println(" aabb ${FirstUniqueCharInString().findUniqueChar("aabb")}")
}