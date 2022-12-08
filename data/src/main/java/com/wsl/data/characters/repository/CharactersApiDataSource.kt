package com.wsl.data.characters.repository


import com.wsl.data.characters.apiservice.CharactersApiService
import com.wsl.data.characters.mappers.makeCharacterEntityMapper
import com.wsl.data.characters.mappers.makeCharacterEntityMapperList
import com.wsl.data.characters.model.MarvelServerResponse
import com.wsl.data.comics.mappers.makeComicListFromResponse
import com.wsl.data.comics.model.ComicServerResponse
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result
import com.wsl.data.utils.Request
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.map


class CharactersApiDataSource(
    private val apiService: CharactersApiService
) {

    suspend fun getAllCharacters(limit: Int, offset: Int): Result<Failure, List<CharacterEntity>> {
        val response = apiService.getAllCharacters(limit, offset)
        return Request(
            response,
            MarvelServerResponse()
        ).map(makeCharacterEntityMapperList())
    }

    suspend fun getCharacter(id: Int): Result<Failure, CharacterEntity> {
        val response = apiService.getCharacter(id)
        return Request(
            response,
            MarvelServerResponse()
        ).map(makeCharacterEntityMapper())
    }

    suspend fun getCharacterComics(limit: Int, offset: Int, id: Int): Result<Failure, List<ComicEntity>> {
        val response = apiService.getCharacterComics(id, limit, offset)
        return Request(
            response,
            ComicServerResponse()
        ).map(makeComicListFromResponse())
    }

}