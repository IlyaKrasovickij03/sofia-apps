package com.mk_sofia.feature_categories_screen.domain

import com.mk_sofia.feature_categories_screen.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.feature_categories_screen.domain.usecases.GetProductsByCategoryIdUseCase
import com.mk_sofia.feature_categories_screen.domain.usecases.GetProductsByCategoryIdWithLimitUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCategoriesUseCase> {
        GetAllCategoriesUseCase(sofiaRepository = get())
    }
    factory<GetProductsByCategoryIdUseCase> {
        GetProductsByCategoryIdUseCase(sofiaRepository = get())
    }
    factory<GetProductsByCategoryIdWithLimitUseCase> {
        GetProductsByCategoryIdWithLimitUseCase(sofiaRepository = get())
    }
}