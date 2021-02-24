package com.panda.kotlinpractice.jetpack.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.panda.kotlinpractice.R
import com.panda.kotlinpractice.databinding.ActivityTwoWayBindingBinding

class ActivityTwoWayBinding : AppCompatActivity() {
    lateinit var binding:ActivityTwoWayBindingBinding
    lateinit var viewModel: TwoWayDataBindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_two_way_binding)
        viewModel = ViewModelProvider(this).get(TwoWayDataBindingViewModel::class.java)
        binding.textData = viewModel
        binding.lifecycleOwner = this
    }
}