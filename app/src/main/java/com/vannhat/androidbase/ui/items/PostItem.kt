package com.vannhat.androidbase.ui.items

import com.vannhat.androidbase.domain.entities.PostModel

data class PostItem(val postModel: PostModel, override var viewType: Int = POST_ITEM) : ViewItem()