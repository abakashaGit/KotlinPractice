package com.panda.kotlinpractice.design_pattern

/*
Builder design pattern is a creational design pattern where you no need to expose the logic or steps
the Object is created instead provide one object.
Builder design pattern returns an immutable object.
 */

 class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?) {

     data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null) {
        // in this constructor we can make some parameters non null to make it mandatory parameter
        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = FoodOrder(bread, condiments, meat, fish)
    }
}

fun main() {
//    var myMobile: Mobile = Mobile.Builder(4, 48).create()
//    print(" ram is ${myMobile.ram} \n camera is ${myMobile.camera} \n os is ${myMobile.os}")
//
//    var myIphone: Mobile = Mobile.Builder(3, 108).create()
//    println("os of object is ${myIphone.ram}")
    var food =FoodOrder.Builder().build()
    print(" bread ${food.bread} condiment ${food.condiments} meat ${food.meat} fish ${food.fish}")

}

class Mobile private constructor(builder: Builder) {
    val ram: Int = builder.ram
    val camera: Int = builder.camera
    val displaySize: Float = builder.displaySize
    val processorName: String = builder.processorName
    val os: String = builder.os

    class Builder(val ram: Int, val camera: Int) {
        var displaySize: Float = 6.5F
        var processorName: String = "Snapdragon"
        var os: String = "Android"

        fun displaySize(size: Float) = apply { this.displaySize = size }
        fun processorName(name: String) = apply { this.processorName = name }
        fun os(osName: String) = apply { this.os = osName }

        fun create(): Mobile {
            return Mobile(this)
        }
    }
}

