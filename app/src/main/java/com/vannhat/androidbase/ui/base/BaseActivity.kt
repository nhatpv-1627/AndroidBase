package com.vannhat.androidbase.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vannhat.androidbase.BR
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutId: Int

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this@BaseActivity

    }
}
