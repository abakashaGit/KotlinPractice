package com.panda.kotlinpractice.basics

fun main() {
    var a:Int = 40
    var b:Int = 20

    var output : String = if (a > b){ // the expression can be stored to the variable upfront
        "a is greater"
    }else if(b > a){
        "b is greater"
    }else{
        "both are same"
    }
    println(output)

    // when is similar to the switch case in java
    when(a){
        10 -> println(" a is 10")
        20 -> print("a is 20")
        30,40 -> println("a is either 30 or 40")
        in 60..80 -> println("between 60 to 80")
        else -> println("non of the above")

    }

    // the above same statement can also be written as expression
    var output1:String = when(a){
        10 -> " a is 10"
        20 -> "a is 20"
        30,40 -> "a is either 30 or 40"
        in 60..80 -> "between 60 to 80"
        else -> "non of the above"
    }
    println("written as statement "+output1)
}