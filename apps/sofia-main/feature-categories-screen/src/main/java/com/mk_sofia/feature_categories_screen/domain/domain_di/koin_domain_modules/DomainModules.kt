package com.mk_sofia.feature_categories_screen.domain.domain_di.koin_domain_modules

import com.mk_sofia.feature_categories_screen.domain.usecases.GetAllCategoriesUseCase
import com.mk_sofia.feature_categories_screen.domain.usecases.GetProductsByCategoryIdUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCategoriesUseCase> {
        GetAllCategoriesUseCase(sofiaRepository = get())
    }
    factory<GetProductsByCategoryIdUseCase> {
        GetProductsByCategoryIdUseCase(sofiaRepository = get())
    }
}