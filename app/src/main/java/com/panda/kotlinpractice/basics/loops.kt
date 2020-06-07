package com.panda.kotlinpractice.basics

fun main() {

    for (number in 0..10){
        println(number)
    }// prints from 0 to 10

    for (number in 10 downTo 0){
        println(number)
    }// prints from 10 to 0

    for(number in 0 until 10){
        println(number)
    }// prints all from 0 to 9 skipping 10

    for (number in 0..10 step 3){
        println(number)
    } //prints all from 0 to 10 with interval of 3 like 0,3,6,9

    //while loop is same as the java

    //a simple logic to print prime numbers between range
    outer@ for (n in 2..10) {
        for (d in 2 until n) {
            println("n : "+n+" d : "+d)
            if (n % d == 0) continue@outer
        }
        println("$n is prime")
    }

}