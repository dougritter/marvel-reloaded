package com.dougritter.marvel.features.characters

import com.dougritter.marvel.core.interactor.UseCase
import com.dougritter.marvel.core.platform.KeysRepository
import javax.inject.Inject

class GetCharacters
@Inject constructor(private val charactersRepository: CharactersRepository,
                    private val keysRepository: KeysRepository):
        UseCase<List<CharacterInfo>, UseCase.None>(){

    override suspend fun run(params: None) = charactersRepository.characters(keysRepository)

}