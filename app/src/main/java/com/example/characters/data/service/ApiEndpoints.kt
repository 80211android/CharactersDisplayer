package com.example.characters.data.service

import com.example.characters.data.model.Character
import com.example.characters.data.model.CharacterResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiEndpoints {

    @GET("character/?page=18")
    fun getCharacters(): Observable<CharacterResponse>
}
