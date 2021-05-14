package com.panda.kotlinpractice.coroutines_example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class DataManager :ViewModel(){

    suspend fun getUserData():Int{
        var result2 = 0
        val finalResult = coroutineScope {
            val result1= async(Dispatchers.IO) {
                delay(1000)
                50
            }
            launch(Dispatchers.IO) {
                delay(1000)
                result2 = 40
            }
        viewModelScope.launch {

        }
            return@coroutineScope result1.await() + result2
        }

        return finalResult
    }

}

fun main() {

}