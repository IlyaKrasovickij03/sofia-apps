package com.mk_sofia.feature_categories_screen.presentation.presentation_di.koin_presentation_modules

import com.mk_sofia.feature_categories_screen.presentation.categories_screen.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<CategoriesViewModel> {
        CategoriesViewModel(
            getAllCategoriesUseCase = get(),
            getProductsByCategoryIdUseCase = get(),
        )
    }

}