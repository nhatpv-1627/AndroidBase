package com.vannhat.androidbase.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vannhat.androidbase.BR
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {
    abstract val viewModel: V

    @get:LayoutRes
    abstract val layoutId: Int

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.apply {
            lifecycleOwner = this@BaseActivity
            //setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }
    }
}
