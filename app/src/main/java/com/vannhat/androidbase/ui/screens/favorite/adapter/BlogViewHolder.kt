package com.vannhat.androidbase.ui.screens.favorite.adapter

import com.vannhat.androidbase.databinding.ItemBlogBinding
import com.vannhat.androidbase.ui.base.BaseViewHolder
import com.vannhat.androidbase.ui.items.BlogItem

class BlogViewHolder(binding: ItemBlogBinding) :
    BaseViewHolder<ItemBlogBinding, BlogItem>(binding) {

    override fun bind(item: BlogItem) {
        binding.blog = item
    }
}
