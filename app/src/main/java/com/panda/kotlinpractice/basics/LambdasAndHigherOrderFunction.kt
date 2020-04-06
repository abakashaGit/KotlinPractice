package com.panda.kotlinpractice.basics

import kotlin.random.Random

fun main() {

    // Lambdas are the in-line funtions which can be assigned to a variable
    val square :(Int) -> Int = {value -> value * value}

    /*
    val - syntax for making lambda
    square - can be used as a funtion which return square of input
    (Int) - is the input type for the lambda
    -> Int - is the return type for the lambda
    = {} the lambda expression or the actual logic
     */
    println(square(5)) // prints 25

    // few other example
    val add:(Int,Int) -> Int = {a,b -> a+b} // lambda for addition of two number
    println(add(4,5)) // prints 9

    val printTheString:(String) -> Unit = { value -> println(value)} // lambda for printing the string

    printTheString("Hello Lambda") // simply prints the string in the parameter, In Android we can use for Toast messages

    //END of Lambda

    //HigherOrderFuntion
    /*
    HigherOrder funtions are the funtions which can take funtions as argument and return function
     */
    AwesomeLambda.passMeTheFuntion {
        println("Here is the funtion implementation")
    }
    /*
    The output :
        do something before executing the funtion
        Here is the funtion implementation
     */

    /*
    NetworkFetch is a example for demonstrating HigherOrder funtion
    We will pass two funtions one for the success and other is for the failure
    As mentioned inthe funtion fetchData
     */
    println("next exmple \n")
    val networkRequest = NetworkRequest()
    networkRequest.fetchData({
            value -> println(value)
    },{
            value -> println(value)
    })

    //Here we will call returnMeAddFuntion to get the add funtion
    val add_funtion = networkRequest.returnMeAddFuntion()
    val output = add_funtion(6,5)
    println("calling the returned function $output")

}

object AwesomeLambda {
    fun passMeTheFuntion(abc:() -> Unit){
        println(" do something before executing the funtion")
        abc()
    }
}

//Simple class for demonstrating HigherOrder funtion
class NetworkRequest{
    /*
    1 - In this the function can take funtion as parameter and execute the funtion
        -success : (result :String) -> Unit // "success" is the funtion name which takes "result" of type string as parameter
        with return type as Unit(void in java)
        -failure: (error:String)->Unit // similar funtion as the success
        -fetchResponseFromServer // a funtion to show that we can do this to fetch the data from the server
        - if else is to check if the server fetch is success or failure
     */
    fun fetchData(success : (result :String) -> Unit, failure: (error:String)->Unit){
        val response = fetchResponseFromServer()
        if (response == 1){ // success
            success("The fetch is success")
        }else{ // failure
            failure("There is some error")
        }

    }

    fun fetchResponseFromServer():Int{ // faking a server call
        return Random.nextInt(1,3) // assume if 1 is success and 2 is failure
    }

    fun returnMeAddFuntion():((Int,Int) ->Int){
        return ::add
    }
    fun add(a:Int,b:Int):Int{
        return a+b
    }
}