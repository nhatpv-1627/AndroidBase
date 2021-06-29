package com.vannhat.androidbase.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.vannhat.androidbase.ui.items.ViewItem

open class BaseViewHolder<out T : ViewDataBinding, V : ViewItem> constructor(
    val binding: T
) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(item: V) {
        binding.executePendingBindings()
    }
}
