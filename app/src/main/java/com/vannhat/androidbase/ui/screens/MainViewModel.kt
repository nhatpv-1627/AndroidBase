package com.vannhat.androidbase.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vannhat.androidbase.domain.usecase.UploadImageDirectUseCase
import com.vannhat.androidbase.domain.usecase.base.NoneInput
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val  test  = UploadImageDirectUseCase()

    fun aaa(){
        viewModelScope.launch {
            val a = async { test(NoneInput()) }
            val re :String = a.await()
        }

    }
}
