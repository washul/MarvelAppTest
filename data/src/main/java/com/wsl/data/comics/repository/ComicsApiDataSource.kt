package com.wsl.data.comics.repository

import com.wsl.data.comics.apiservice.ComicsApiService
import com.wsl.data.comics.mappers.makeComicListFromResponse
import com.wsl.data.comics.model.ComicServerResponse
import com.wsl.data.utils.Request
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result
import com.wsl.utils.map

class ComicsApiDataSource(private val service: ComicsApiService) {

    suspend fun getComics(limit: Int, offset: Int): Result<Failure, List<ComicEntity>> {
        val response = service.getComics(limit, offset)
        return Request(
            response,
            ComicServerResponse()
        ).map(makeComicListFromResponse())
    }
}