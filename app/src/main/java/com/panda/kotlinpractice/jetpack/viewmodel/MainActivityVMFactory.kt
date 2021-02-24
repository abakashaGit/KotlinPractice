package com.panda.kotlinpractice.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityVMFactory(private val startSum:Int):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(MainActivityVMViewModel::class.java)){
           return MainActivityVMViewModel(startSum) as T
       }
        throw IllegalArgumentException("Unknown view model class")
    }

}