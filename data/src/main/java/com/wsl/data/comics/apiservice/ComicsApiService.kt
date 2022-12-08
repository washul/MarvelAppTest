package com.wsl.data.comics.apiservice

import com.wsl.data.characters.model.MarvelServerResponse
import com.wsl.data.comics.model.ComicServerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsApiService {

    @GET("comics")
    suspend fun getComics(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int):
            Response<ComicServerResponse>
}