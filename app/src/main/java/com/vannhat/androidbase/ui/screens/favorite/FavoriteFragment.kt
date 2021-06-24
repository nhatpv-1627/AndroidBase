package com.vannhat.androidbase.ui.screens.favorite

import android.os.Bundle
import android.view.View
import com.vannhat.androidbase.R
import com.vannhat.androidbase.databinding.FragmentFavoriteBinding
import com.vannhat.androidbase.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {
    override val viewModel: FavoriteViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_favorite

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

    }
}
