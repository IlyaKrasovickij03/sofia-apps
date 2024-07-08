package com.mk_sofia.feature_sofia_cached_image.di

import com.mk_sofia.feature_sofia_cached_image.CachedImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cachedImageModule = module {
    viewModel<CachedImageViewModel> {
        CachedImageViewModel()
    }
}