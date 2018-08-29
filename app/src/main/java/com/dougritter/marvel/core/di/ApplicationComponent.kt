package com.dougritter.marvel.core.di

import com.dougritter.marvel.AndroidApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)

}