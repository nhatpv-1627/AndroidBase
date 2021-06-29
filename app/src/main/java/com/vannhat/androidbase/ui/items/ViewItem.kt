package com.vannhat.androidbase.ui.items

open class ViewItem {
    open var viewType: Int = DEFAULT_ITEM_TYPE
}

private const val DEFAULT_ITEM_TYPE = -111111
const val POST_ITEM = 1
const val BLOG_ITEM = 2
