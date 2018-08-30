package com.dougritter.marvel.features.characters

import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersService
@Inject constructor(private val retrofit: Retrofit): CharactersApi {

    private val charactersApi by lazy { retrofit.create(CharactersApi::class.java) }

    override fun characters(apiKey: String, ts: String, hash: String) : Call<CharactersEntity>
            = charactersApi.characters(apiKey, ts, hash)

}