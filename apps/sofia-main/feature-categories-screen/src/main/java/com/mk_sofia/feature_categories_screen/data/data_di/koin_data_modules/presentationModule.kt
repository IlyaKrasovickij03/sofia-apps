package com.mk_sofia.feature_categories_screen.data.data_di.koin_data_modules

import com.mk_sofia.feature_categories_screen.data.network.CategoriesScreenApi
import com.mk_sofia.feature_categories_screen.data.repository.SofiaRepositoryImpl
import com.mk_sofia.feature_categories_screen.domain.repository.SofiaRepository
import org.koin.dsl.module

val dataModule = module {
    factory<SofiaRepository> {
        SofiaRepositoryImpl(categoriesScreenApi = get())
    }

    factory<CategoriesScreenApi> {
        CategoriesScreenApi()
    }
}