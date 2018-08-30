package com.dougritter.marvel.features.characters

import android.arch.lifecycle.MutableLiveData
import com.dougritter.marvel.core.interactor.UseCase.None
import com.dougritter.marvel.core.platform.BaseViewModel
import javax.inject.Inject

class CharactersViewModel
@Inject constructor(private val getCharacters: GetCharacters) : BaseViewModel() {

    var characters: MutableLiveData<List<CharacterView>> = MutableLiveData()

    fun loadCharacters() = getCharacters(None()) { it.either(::handleFailure, ::handleCharactersList)}

    private fun handleCharactersList(charactersList: List<CharacterInfo>) {
        this.characters.value = charactersList.map { CharacterView(it.id, it.name, it.thumbnail) }
    }


}