package com.example.characters.data.model

data class CharacterResponse(
    val info: Info,
    var results: List<Character>
)