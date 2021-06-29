package com.vannhat.androidbase.ui.screens.favorite.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.ItemBlogBinding
import com.vannhat.androidbase.databinding.ItemPostBinding
import com.vannhat.androidbase.ui.base.BaseRecyclerViewAdapter
import com.vannhat.androidbase.ui.base.BaseViewHolder
import com.vannhat.androidbase.ui.items.POST_ITEM
import com.vannhat.androidbase.ui.items.PostItem
import com.vannhat.androidbase.ui.items.ViewItem

class FavoriteAdapter : BaseRecyclerViewAdapter<ViewItem, ViewDataBinding>() {
    override fun createBinding(
        parent: ViewGroup,
        viewType: Int?
    ): Any {
        return when (viewType) {
            POST_ITEM ->
                PostViewHolder(inflateView(R.layout.item_post, parent) as ItemPostBinding)
            else -> BlogViewHolder(inflateView(R.layout.item_blog, parent) as ItemBlogBinding)
        }
    }

    override fun bind(holder: BaseViewHolder<ViewDataBinding, ViewItem>, item: ViewItem) {
        holder.bind(item)
    }
}
