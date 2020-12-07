package com.dmioto.githubjavapop.ui.core

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.work.*
import com.dmioto.githubjavapop.ui.core.di.DataModule
import com.dmioto.githubjavapop.ui.core.di.DomainModule
import com.dmioto.githubjavapop.ui.core.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


internal class GithubJavaPopApp : Application(), Configuration.Provider {

    companion object {
        lateinit var appContext: Context
        lateinit var sharedPreferences: SharedPreferences
        var deviceUUID: String = ""
    }

    override fun onCreate() {
        super.onCreate()

        /* Set Application Context */
        appContext = applicationContext

        /* Setup Koin */
        startKoin {
            androidContext(appContext)
            modules(listOf(PresentationModule.get(), DomainModule.get(), DataModule.get()))
        }
    }
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().build()
    }

}