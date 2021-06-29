package com.vannhat.androidbase.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.vannhat.androidbase.ui.items.ViewItem
import java.util.concurrent.Executors

abstract class BaseRecyclerViewAdapter<T : ViewItem, B : ViewDataBinding>(
    callBack: DiffUtil.ItemCallback<T> = BaseDiffUtil()
) : ListAdapter<T, BaseViewHolder<ViewDataBinding, T>>(
    AsyncDifferConfig.Builder(callBack)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewDataBinding, T> {
        return createBinding(parent, viewType) as BaseViewHolder<ViewDataBinding, T>
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding, T>, position: Int) {
        getItem(position)?.let { bind(holder as BaseViewHolder<B, T>, it) }
    }

    protected abstract fun createBinding(
        parent: ViewGroup,
        viewType: Int? = 0
    ): Any?

    protected abstract fun bind(holder: BaseViewHolder<B, T>, item: T)

    protected fun inflateView(@LayoutRes layoutRes: Int, parent: ViewGroup): B {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layoutRes, parent, false
        )
    }
}
