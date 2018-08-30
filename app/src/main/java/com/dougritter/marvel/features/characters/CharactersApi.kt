package com.dougritter.marvel.features.characters

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

internal interface CharactersApi {

    companion object {
        private const val CHARACTERS = "characters"
        private const val API_KEY = "apikey"
        private const val TIMESTAMP = "ts"
        private const val HASH = "hash"
        private const val HEADERS = "Accept: */*"

    }

    @Headers(HEADERS)
    @GET(CHARACTERS)
    fun characters(@Query(API_KEY) apiKey: String,
                   @Query(TIMESTAMP) ts: String,
                   @Query(HASH) hash: String): Call<CharactersEntity>

}