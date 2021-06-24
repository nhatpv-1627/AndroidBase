package com.vannhat.androidbase.di

import com.vannhat.androidbase.ui.screens.MainViewModel
import com.vannhat.androidbase.ui.screens.favorite.FavoriteViewModel
import com.vannhat.androidbase.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { FavoriteViewModel() }
}
