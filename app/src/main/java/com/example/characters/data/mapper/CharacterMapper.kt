package com.example.characters.data.mapper

import com.example.characters.data.model.Character
import com.example.characters.data.model.CharacterResponse
import com.example.characters.presentation.model.CharacterPresentation
import io.reactivex.Observable

class CharacterMapper {

    fun characterResponseToCharacterPresentationList(charactersResponse: Observable<CharacterResponse>): Observable<List<CharacterPresentation>> {
        return charactersResponse.map { characterToCharacterPresentationList(it.results) }
    }

    fun characterToCharacterPresentationList(charactersList: List<Character>): List<CharacterPresentation> {
        return charactersList.map { characterToCharacterPresentation(it) }
    }

    private fun characterToCharacterPresentation(character: Character): CharacterPresentation {
        return CharacterPresentation(
            name = character.name,
            status = character.status,
            url = character.image
        )
    }
}
