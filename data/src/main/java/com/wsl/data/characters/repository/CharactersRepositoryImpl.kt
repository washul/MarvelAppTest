package com.wsl.data.characters.repository

import com.wsl.domain.characters.CharactersRepository
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersRepositoryImpl (
    private val localDataSource: CharactersLocalDataSource,
    private val remoteDataSource: CharactersApiDataSource
): CharactersRepository {

    private val dispatcher = Dispatchers.IO

    override suspend fun getAllCharacters(limit: Int, offset: Int):
            Result<Failure, List<CharacterEntity>>
    = withContext(dispatcher) {
        remoteDataSource.getAllCharacters(limit, offset)
    }

    override suspend fun getCharacter(id: Int):
            Result<Failure, CharacterEntity>
    = withContext(dispatcher) {
        remoteDataSource.getCharacter(id)
    }

    override suspend fun getCharacterComics(
        limit: Int,
        offset: Int,
        characterID: Int
    ): Result<Failure, List<ComicEntity>>
    = withContext(dispatcher) {
        remoteDataSource.getCharacterComics(limit, offset, characterID)
    }

}