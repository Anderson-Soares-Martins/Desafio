package com.example.heroes.data.service.api

import com.example.heroes.data.response.DataBaseResponse
import com.example.heroes.data.response.MarvelDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

   @GET("/v1/public/characters")
   fun getCharacters() : Call<MarvelDataResponse<DataBaseResponse>>

   @GET("/v1/public/characters/{id}")
   fun getCharacter(@Path("id") id: Int): Call<MarvelDataResponse<DataBaseResponse>>
}