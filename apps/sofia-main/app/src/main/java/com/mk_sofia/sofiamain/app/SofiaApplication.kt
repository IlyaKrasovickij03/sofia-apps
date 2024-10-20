package com.mk_sofia.sofiamain.app

import android.app.Application
import com.mk_sofia.feature_categories_screen.data.data_di.koin_data_modules.dataModule
import com.mk_sofia.feature_categories_screen.domain.domainModule
import com.mk_sofia.feature_categories_screen.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SofiaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@SofiaApplication)
            modules(
                modules = listOf(
                    dataModule,
                    domainModule,
                    presentationModule,
                )
            )
        }
    }
}