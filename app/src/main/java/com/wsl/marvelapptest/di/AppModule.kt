package com.wsl.marvelapptest.di

import com.wsl.marvelapptest.common.ThemeConfigManagement
import com.wsl.marvelapptest.layout.details.DetailsViewModel
import com.wsl.marvelapptest.layout.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { (characterID: Int) -> DetailsViewModel(get(), get(), characterID, get()) }

    single<ThemeConfigManagement> { ThemeConfigManagement() }
}