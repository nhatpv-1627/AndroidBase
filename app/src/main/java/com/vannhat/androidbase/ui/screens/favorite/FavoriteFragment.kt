package com.vannhat.androidbase.ui.screens.favorite

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.FragmentFavoriteBinding
import com.vannhat.androidbase.ui.base.BaseFragment
import com.vannhat.androidbase.ui.screens.favorite.adapter.FavoriteAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {
    override val viewModel: FavoriteViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_favorite

    private lateinit var adapter: FavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        handleEvents()
        observe()
    }

    private fun observe() {
        viewModel.postListLiveData.observe(viewLifecycleOwner) {
            val shuffledList = it.shuffled()
            adapter.submitList(shuffledList)
        }
    }

    private fun initViews() {
        adapter = FavoriteAdapter()
        binding.rvPosts.adapter = adapter
    }

    override fun showLoading(isLoading: Boolean) {
        binding.pbLoading.isVisible = isLoading
        binding.refreshLayout.isRefreshing = false
    }

    private fun handleEvents() {
        binding.refreshLayout.setOnRefreshListener {
            viewModel.getData()
        }
    }
}
