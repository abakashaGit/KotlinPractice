package com.panda.kotlinpractice.basics

// data classes are the objects to hold the data.

fun main() {
    //data class CanNotCreate()
    /*
    / You can not create a data class like above without arguments error throws as
    data class must have at-least one primary constructor parameter
     */
    //data class  CanNotCreate(name:String)
    /*
    You can not even create a data class as above error throws as
    data class primary constructor must have a property type(val/var) parameters
     */

    data class Student(val name:String,val age:Int)
    // here Student is a data class where if you compare the two Student objects with the same value, it will be the same

    val student = Student("Modi",67)
    val student1 = Student("Modi",67)
    if (student == student1){ // this will return true because the Student is a data class not a simple class
        // In case of normal class it will check the address so the result will be false

        println("true")
    }else{
        println("false")
    }
    println(student)
    println(student1) //both will print Student(name=Modi, age=67), because it is not a class it is data class.

    println(student.age)
    println(student1.age) // you can directly access the arguments, even you can change it when it is declared with var keyword

    println(student.component1())
    println(student.component2()) // these will print the first argument and second argument respectively

    val (name,age) = student // here we can destruct the student and store in the a set of val
    print("\n $name $age") // this will print name and age of the student.



}