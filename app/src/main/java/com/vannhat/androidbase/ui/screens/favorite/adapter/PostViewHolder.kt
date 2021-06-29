package com.vannhat.androidbase.ui.screens.favorite.adapter

import com.vannhat.androidbase.databinding.ItemPostBinding
import com.vannhat.androidbase.ui.base.BaseViewHolder
import com.vannhat.androidbase.ui.items.PostItem

class PostViewHolder(binding: ItemPostBinding) :
    BaseViewHolder<ItemPostBinding, PostItem>(binding) {

    override fun bind(item: PostItem) {
        binding.post = item
    }
}
