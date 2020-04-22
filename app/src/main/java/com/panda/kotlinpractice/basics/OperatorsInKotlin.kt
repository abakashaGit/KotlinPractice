package com.panda.kotlinpractice.basics

// Elvis Operator
// used to safely unwrap the nullable value
//It’s represented as ?: over the nullable type.
// The value on the right hand side would be used if the nullable type holds a null.

fun main() {

    var nullable_value:String? = null
    println("the value is $nullable_value") // the output is - "the value is null"
    var newValue = nullable_value?:"DefaultValue"
    println("the value after elvis operator $newValue") // output is - "the value after elvis operator DefaultValue"

}