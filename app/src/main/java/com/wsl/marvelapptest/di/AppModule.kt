package com.wsl.marvelapptest.di

import com.wsl.marvelapptest.layout.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
}