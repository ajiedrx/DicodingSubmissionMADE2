package com.example.dicodingsubmission2made

import android.app.Application
import android.content.Context
import com.example.dicodingsubmission2made.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

    companion object {
        private var context: Context? = null
        val appContext: Context
            get() = context!!
    }
}