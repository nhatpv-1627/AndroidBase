package com.vannhat.androidbase.ui.screens

import android.os.Bundle
import android.widget.Toast
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.ActivityMainBinding
import com.vannhat.androidbase.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int = R.layout.activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.tvHello.setOnClickListener {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        }
    }
}
