package com.dougritter.marvel.features.characters

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CharactersApi {

    companion object {
        private const val CHARACTERS = "characters"
        private const val API_KEY = "apikey"

    }

    @GET(CHARACTERS) fun characters(@Path(API_KEY) apiKey: String): Call<CharactersEntity>

}