package com.vannhat.androidbase.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vannhat.androidbase.BR
import androidx.databinding.ViewDataBinding
import com.google.gson.Gson
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), KoinComponent {

    val gson: Gson by inject()

    @get:LayoutRes
    abstract val layoutId: Int

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this@BaseActivity

    }
}
