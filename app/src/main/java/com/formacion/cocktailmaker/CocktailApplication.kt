package com.formacion.cocktailmaker

import android.app.Application
import com.formacion.cocktailmaker.di.dataModule
import com.formacion.cocktailmaker.di.domainModule
import com.formacion.cocktailmaker.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class CocktailApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@CocktailApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}