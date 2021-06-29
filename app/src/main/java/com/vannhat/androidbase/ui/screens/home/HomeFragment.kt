package com.vannhat.androidbase.ui.screens.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.FragmentHomeBinding
import com.vannhat.androidbase.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_home

    private lateinit var adapter: PostAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        handleEvents()
        observe()
    }

    private fun handleEvents() {
        binding.refreshLayout.setOnRefreshListener {
            viewModel.getPost()
        }
    }

    private fun observe() {
        viewModel.getPostsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun showLoading(isLoading: Boolean) {
        binding.pbLoading.isVisible = isLoading
        binding.refreshLayout.isRefreshing = false
    }

    private fun initViews() {
        adapter = PostAdapter()
        binding.rvPosts.adapter = adapter
    }
}
