package com.panda.kotlinpractice.jetpack.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayDataBindingViewModel():ViewModel() {
    var textValue = MutableLiveData<String>()
    init {
        textValue.value = "start"
    }

}