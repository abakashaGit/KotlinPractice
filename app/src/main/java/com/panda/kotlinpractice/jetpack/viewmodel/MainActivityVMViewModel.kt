package com.panda.kotlinpractice.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
/*
ViewModel is a lifecycle conscious component which can hold the data while some configuration change happens
Config changes like -Screen rotation, language change, multiwindow mode, keyboard changes
 */
class MainActivityVMViewModel(startSum:Int):ViewModel() {
    private var sum = MutableLiveData<Int>()
    init {
        sum.value = startSum
    }
    val sumTotal : LiveData<Int>
        get() = sum // kotlin getter for encapsulation of "sum" as "sum" is private

    fun addValue(newValue:Int){
        sum.value = sum.value?.plus(newValue)
    }

    override fun onCleared() {
        super.onCleared()

    }
}
