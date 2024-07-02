package com.mk_sofia.sofiamain.core.app.di.data_di.koin_data_modules

import com.mk_sofia.sofiamain.data.network.api.SofiaNetworkApi
import com.mk_sofia.sofiamain.data.repository.SofiaRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    factory {
        SofiaRepositoryImpl(sofiaApi = get())
    }

    factory {
        SofiaNetworkApi()
    }
}