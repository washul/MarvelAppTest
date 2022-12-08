package com.wsl.data.characters.apiservice

import com.wsl.data.characters.model.MarvelServerResponse
import com.wsl.data.comics.model.ComicServerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApiService {

    @GET("characters")
    suspend fun getAllCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<MarvelServerResponse>

    @GET("characters/{characterId}")
    suspend fun getCharacter(
        @Path("characterId") id: Int
    ): Response<MarvelServerResponse>

    @GET("characters/{characterId}/comics")
    suspend fun getCharacterComics(
        @Path("characterId") id: Int,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ComicServerResponse>

}