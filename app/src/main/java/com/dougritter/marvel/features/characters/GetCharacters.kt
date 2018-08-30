package com.dougritter.marvel.features.characters

import com.dougritter.marvel.core.interactor.UseCase
import javax.inject.Inject

class GetCharacters
@Inject constructor(private val charactersRepository: CharactersRepository):
        UseCase<List<CharacterInfo>, UseCase.None>(){

    override suspend fun run(params: None) = charactersRepository.characters("asd")

}