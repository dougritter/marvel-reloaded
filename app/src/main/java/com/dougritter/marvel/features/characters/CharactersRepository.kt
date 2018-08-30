package com.dougritter.marvel.features.characters

import com.dougritter.marvel.core.exception.Failure
import com.dougritter.marvel.core.functional.Either
import com.dougritter.marvel.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface CharactersRepository {

    fun characters(apiKey: String): Either<Failure, List<CharacterInfo>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: CharactersService): CharactersRepository {

        override fun characters(apiKey: String): Either<Failure, List<CharacterInfo>> {
            return when (networkHandler.isConnected) {
                true -> request(service.characters(apiKey), { it.toCharacters() }, CharactersEntity.empty())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform(response.body() ?: default))
                    false -> Either.Left(Failure.ServerError())
                }

            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError())
            }
        }
    }

}