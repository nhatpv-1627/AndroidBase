package com.vannhat.androidbase.ui.items

import com.vannhat.androidbase.domain.entities.BlogModel

data class BlogItem(val postModel: BlogModel, override var viewType: Int = BLOG_ITEM) : ViewItem()
