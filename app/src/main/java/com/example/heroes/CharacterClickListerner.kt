package com.example.heroes

import com.example.heroes.data.response.CharacterResponse

interface CharacterClickListerner {
    fun onClick(character: CharacterResponse)
}