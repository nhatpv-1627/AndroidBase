package com.vannhat.androidbase.ui.screens.home

import androidx.lifecycle.MutableLiveData
import com.vannhat.androidbase.domain.usecase.GetPostsUseCase
import com.vannhat.androidbase.domain.usecase.base.NoneInput
import com.vannhat.androidbase.ui.base.BaseViewModel
import com.vannhat.androidbase.ui.items.PostItem

class HomeViewModel(private val getPostsUseCase: GetPostsUseCase) : BaseViewModel() {

    val getPostsLiveData = MutableLiveData<List<PostItem>>()

    init {
        getPost()
    }

    fun getPost() {
        viewModelScope(onSuccess = {
            getPostsLiveData.value = it.map { post -> PostItem(post) }
        }, onRequest = {
            getPostsUseCase(NoneInput())
        })
    }

}
