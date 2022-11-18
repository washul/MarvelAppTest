package com.wsl.marvelapptest

import android.app.Application
import com.wsl.data.di.dataModule
import com.wsl.domain.di.DomainModule
import com.wsl.marvelapptest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //Declare context application
            androidContext(this@MarvelApplication)
            //Declare modules
            modules(
                DomainModule,
                dataModule,
                appModule
            )
        }
    }

}