package com.vannhat.androidbase.ui.screens.favorite

import androidx.lifecycle.MutableLiveData
import com.vannhat.androidbase.domain.entities.BlogModel
import com.vannhat.androidbase.domain.entities.PostModel
import com.vannhat.androidbase.domain.usecase.GetBlogPostsUseCase
import com.vannhat.androidbase.domain.usecase.GetFlowPostsUseCase
import com.vannhat.androidbase.domain.usecase.base.NoneInput
import com.vannhat.androidbase.ui.base.BaseViewModel
import com.vannhat.androidbase.ui.items.BlogItem
import com.vannhat.androidbase.ui.items.PostItem
import com.vannhat.androidbase.ui.items.ViewItem
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.zip

class FavoriteViewModel(
    private val getFlowPostsUseCase: GetFlowPostsUseCase,
    private val getBlogPostsUseCase: GetBlogPostsUseCase
) : BaseViewModel() {

    val postListLiveData = MutableLiveData<List<ViewItem>>()

    init {
        getData()
    }

    fun getData() {
        viewModelScope(onRequest = {
            val l1 = async { getBlogPostsUseCase(NoneInput()) }
            val l2 = async { getFlowPostsUseCase(NoneInput()) }
            l1.await().zip(l2.await()) { first, second ->
                first.plus(second)
            }
        }, onSuccess = {
            viewModelScope {
                it.collect {
                    postListLiveData.value = it.map { model ->
                        if (model is BlogModel) BlogItem(model)
                        else PostItem(model as PostModel)
                    }
                }
            }
        })
    }
}
