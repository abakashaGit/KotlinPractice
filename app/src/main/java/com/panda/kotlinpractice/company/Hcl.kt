package com.panda.kotlinpractice.company

import java.util.*

lateinit var late_init:String
class Hcl {
}

fun main() {
    // accessing the late init variable without initializing it
   // println(late_init) //  kotlin.UninitializedPropertyAccessException:
    // lateinit property late_init has not been initialized
    //add to mutable list and store and print
    val list = mutableListOf<Int>(1, 2, 3)
    val list2 = list.add(4) // this tricks with the variable name list, the method add will
    // return boolean, so in this case "true" will be printed
    println(list2)

    val run = 10 to 30 // this creates a pair of (10,30)
    println(run) // this prints (10,30)

    val n:Int

    val ran = 1.rangeTo(5)
    println(ran.first)

    println(devive())//try catch 17

    val a1 = arrayOf(1, 2, 3)
    val a2 = arrayOf(1, 2, 3)
    println(a1.equals(a2)) // false
    println(a1 == a2) // false
    println(a1 === a2) // false

    val a3 = a1
    println(" a3 \n")
    println(a1.equals(a3)) // true
    println(a1 == a3) // true
    println(a1 === a3) // true

    a3[0] = 5
    println(" a3[0] = 5 ${a3[0]}\n")
    println(a1.equals(a3)) // true
    println(a1 == a3) // true
    println(a1 === a3) // true

    println("arrayOf(1,2,3) ${arrayOf(1, 2, 3).equals(arrayOf(1, 2, 3))}") // this is also false

    /*
    So .equals , ==, === does not check values, it check the reference is same or not
     */

    val a:Double = 354.03 // when casted to byte will print 98(256 + 96 = 354) .03 is ignored
    val b:Int = 256 // when casted to byte will print 0
    val c:Byte = a.toByte()
    val d:Byte = b.toByte()


    println(" c and d are $c and $d")

    val x:Int? = null
    val sup = x?.toInt() ?: 10
    println("x = $sup")

    val arr1 = intArrayOf(1, 2, 3, 4)
    val arr2 = intArrayOf(1, 2, 3, 4)
    println("arr1.equals(arr2) :" + (arr1 == arr2)) // checks references so false

    println("Arrays.equals(arr1,arr2) :" + Arrays.equals(arr1, arr2)) // checks values so true

//    generateSequence (2){
//        it *2
//    }.take(10).forEach {
//        if (it%2 == 0) return
//        print("$it ")
//    }
    println("RED test")
    val color:String = "RED"
    val resu = if (color === "RED"){ // this is true
        println("the color is red")
        14
        "Kotlin is awesome"
        // if we are returning two values then the second value will be assigned
    }else{
        "Kotlin is not RED"
        13
    }
    println(resu)
}
fun devive():Int{
    try {
        println("try")
        //val x = 33/0
        println("11")
        return 11 // this is unreachable
    }catch (e: Exception){
        println("catch")
        println("17")
        return 17 // this is unreachable
    }finally {
        println("finally")
        println("88")
        //return 88 // if you return from finally it will ovverride the return of try and catch
    }
    println("After finally") // as return statement is there in try and catch block this becomes un-rechable


    /*
        == checks reference
        equals - checks value
        so output is 10010
         */
}