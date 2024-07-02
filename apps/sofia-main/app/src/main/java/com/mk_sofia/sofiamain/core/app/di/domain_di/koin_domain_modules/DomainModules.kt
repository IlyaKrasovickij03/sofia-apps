package com.mk_sofia.sofiamain.core.app.di.domain_di.koin_domain_modules

import com.mk_sofia.sofiamain.domain.usecases.GetAllCategoriesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllCategoriesUseCase> {
        GetAllCategoriesUseCase(sofiaRepository = get())
    }
}