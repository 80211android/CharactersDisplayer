package com.example.characters.presentation

import com.example.characters.data.Repository
import com.example.characters.presentation.model.CharacterPresentation
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CharacterModel(val repository: Repository): CharacterContract.Model {

    override fun getAllCharacterss(): Observable<List<CharacterPresentation>> {
        return repository.getAllCharacters()
            .subscribeOn(Schedulers.io())
    }
}
