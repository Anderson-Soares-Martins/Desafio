package com.example.heroes.data.response

import com.google.gson.annotations.SerializedName

class DataBaseResponse(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    @SerializedName("results") val characters: List<CharacterResponse>
)