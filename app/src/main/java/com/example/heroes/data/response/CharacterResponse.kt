package com.example.heroes.data.response

var characterList = mutableListOf<CharacterResponse>()

val CHARACTER_ID_EXTRA = "CharacterExtra"

class CharacterResponse (
        val id: Int,
        val name: String,
        val description: String,
        val thumbnail: ThumbnailResponse,
        val comics: ComicsResponse,
        val urls: List<UrlResponse>
        )

