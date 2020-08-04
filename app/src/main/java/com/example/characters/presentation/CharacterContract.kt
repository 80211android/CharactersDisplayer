package com.example.characters.presentation

import com.example.characters.presentation.model.CharacterPresentation
import io.reactivex.Observable

interface CharacterContract {

    interface View {
        fun updateCharacters(characters: List<CharacterPresentation>)
    }

    interface Presenter {
        fun getCharacters()
        fun clear()
    }

    interface Model {
        fun getAllCharacterss(): Observable<List<CharacterPresentation>>
    }
}