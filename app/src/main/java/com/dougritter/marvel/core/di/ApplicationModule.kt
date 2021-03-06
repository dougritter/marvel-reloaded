package com.dougritter.marvel.core.di

import android.content.Context
import com.dougritter.marvel.AndroidApplication
import com.dougritter.marvel.BuildConfig
import com.dougritter.marvel.core.platform.KeysRepository
import com.dougritter.marvel.features.characters.CharactersRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides @Singleton fun provideApplicationContext(): Context = application

    @Provides @Singleton fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com/v1/public/")
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) okHttpClientBuilder
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        return okHttpClientBuilder.build()
    }

    @Provides @Singleton fun provideMoviesRepository(dataSource: CharactersRepository.Network): CharactersRepository = dataSource

    @Provides @Singleton fun provideKeysRepository() =
            KeysRepository(BuildConfig.MARVEL_PUBLIC_KEY, BuildConfig.MARVEL_PRIVATE_KEY)




}