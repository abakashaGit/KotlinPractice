package com.panda.kotlinpractice.simple_programes

object FactorialOfNumber {
    fun findFactorial(input:Int):Int{
        if (input <= 2)
            return input
        var value = input
        var factorial :Int = 1
        while (value > 1){
            factorial *= value
            value--
        }
        return factorial
    }
}

fun main() {
    print("factorial of 3 is ${FactorialOfNumber.findFactorial(3)}")
}