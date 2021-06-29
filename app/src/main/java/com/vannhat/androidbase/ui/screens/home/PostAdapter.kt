package com.vannhat.androidbase.ui.screens.home

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.ItemPostBinding
import com.vannhat.androidbase.ui.base.BaseRecyclerViewAdapter
import com.vannhat.androidbase.ui.base.BaseViewHolder
import com.vannhat.androidbase.ui.items.PostItem

class PostAdapter : BaseRecyclerViewAdapter<PostItem, ItemPostBinding>() {
    override fun createBinding(
        parent: ViewGroup,
        viewType: Int?
    ): BaseViewHolder<ViewDataBinding, PostItem> {
        return BaseViewHolder(inflateView(R.layout.item_post, parent))
    }

    override fun bind(holder: BaseViewHolder<ItemPostBinding, PostItem>, item: PostItem) {
        holder.binding.post = item
    }

}
