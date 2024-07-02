package com.mk_sofia.sofiamain.core.app.di.presentation_di.koin_presentation_modules

import com.mk_sofia.sofiamain.presentation.categories_screen.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CategoriesViewModel(getAllCategoriesUseCase = get())
    }
}