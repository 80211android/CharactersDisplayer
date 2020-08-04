package com.example.characters.data

import com.example.characters.data.mapper.CharacterMapper
import com.example.characters.data.service.RemoteService
import com.example.characters.presentation.model.CharacterPresentation
import io.reactivex.Observable

class Repository(
    val service: RemoteService,
    val mapper: CharacterMapper
) {

    fun getAllCharacters(): Observable<List<CharacterPresentation>> {
        val charactersResponse = service.getClient.getCharacters()
        return mapper.characterResponseToCharacterPresentationList(charactersResponse)
    }
}
