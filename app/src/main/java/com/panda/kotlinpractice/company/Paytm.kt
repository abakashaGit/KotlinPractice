package com.panda.kotlinpractice.company

//Question 1
open class Shoe(val size:Long){
    protected fun printShowSize(){
        print(size) // this will print 41
    }
}

//class AddidasShoe: Shoe {
//    constructor(size: Long) : super(size + 3) {
//
//    }
//}
// the above declaration is same as the bellow declaration
// you can either declare as primary constructor or secondary constructor with super
class AddidasShoe(size: Long) : Shoe(size + 3) {
    init {
        print(printShowSize())
    }
}

fun main(args : Array<String>) {
    AddidasShoe(38)

    //list filter
    val list = listOf<Int>(1,2,3,4,5)
    val filterList = list.filter { value:Int -> value <3  } // lambda expression
    val filter1 = list.filter { it <3 } // scope
    //So both of this filter will work and filter the list.
    println( " filterList :${filterList} filter1 : $filter1")

    compareTo(1,2)
    // map
    val map = mapOf("Dogs" to 10, "cats" to 3,"Birds" to 19)
    map.forEach(fun(key, _){ print(" $key")}) // works fine, prints akk keys Dogs cats Birds
    map.forEach { print(" $it") } // works fine, prints Dogs=10 cats=3 Birds=19
    map.forEach (fun(_,value){ print(" $value") })  // works fine prints all values 10 3 19

    //Car data class
    val car1 = Car("chev",3,1)
    val car2 = car1.copy().apply {
        id = 5
    }
    println(" car1 == car2 ${car1 == car2}")// This will always be true as car2 is copy of car1
    println(" car1 === car2 ${car1 === car2}")// This will always be false as 'id' of both are different

    val wire = Wire(3)
    val paperWire = PaperWire(6)
    println(" wire.length == paperWire.length ${wire.length == paperWire.length}")
    //prints false because paperWire length has 6 and wire length has 3
}

////Wire
open class Wire(open val length:Long)
class PaperWire(override val length: Long):Wire(length-3)



class Painting private constructor(val color1:String, val color2:String){
    constructor(color1:String,color2:String,color3:String) : this(color1,color2) {
    // works fine, it is constructor overloading
        //this.color1 = color3// val can not be re assigned
    }
//    constructor(color1:String,color2:String) { // conflicting overloads
//        // works fine, it is constructor overloading
//        //this.color1 = color3// val can not be re assigned
//    }
}

data class Car(val brand:String, val year:Int){
 var id : Long =-1
    constructor(brand: String,year: Int,id:Long):this(brand,year){
        this.id = id
    }
}

//
private fun compareTo(x:Int,y:Int){
    when{
        x > y -> println("Greater")
        x < y -> println("LESS")
        x == y -> println("Same")
    }
}

//Question 2
open class Component{
    open fun click(){
        println("Clickng from component")
    }
}
abstract class Mouse:Component(){
    abstract override fun click()
}

///Animal
open class Animal(val name:String, open val year :Int = 2000)
//class Dog(override val year:String):Animal("Capy") //Error : overriden type of year is not the same
class Dog(override val year:Int):Animal("Capy") // works fine

