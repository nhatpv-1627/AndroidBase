package com.vannhat.androidbase.ui.screens.home

import android.os.Bundle
import android.view.View
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.FragmentHomeBinding
import com.vannhat.androidbase.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

    }
}
