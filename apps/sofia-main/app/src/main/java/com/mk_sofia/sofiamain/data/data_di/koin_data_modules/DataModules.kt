package com.mk_sofia.sofiamain.data.data_di.koin_data_modules

import com.mk_sofia.sofiamain.data.network.api.SofiaNetworkApi
import com.mk_sofia.sofiamain.data.repository.SofiaRepositoryImpl
import com.mk_sofia.sofiamain.domain.repository.SofiaRepository
import org.koin.dsl.module

val dataModule = module {
    factory<SofiaRepository> {
        SofiaRepositoryImpl(sofiaApi = get())
    }

    factory<SofiaNetworkApi> {
        SofiaNetworkApi()
    }
}