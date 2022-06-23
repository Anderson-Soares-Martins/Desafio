package com.example.heroes.data.response

import com.google.gson.annotations.SerializedName

class MarvelDataResponse<T>(
    @SerializedName("data") val data: DataBaseResponse
)