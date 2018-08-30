package com.dougritter.marvel.core.di

import com.dougritter.marvel.AndroidApplication
import com.dougritter.marvel.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
    fun inject(mainActivity: MainActivity)

}