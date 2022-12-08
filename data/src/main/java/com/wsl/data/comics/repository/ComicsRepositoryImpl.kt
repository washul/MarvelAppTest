package com.wsl.data.comics.repository

import com.wsl.domain.comics.ComicsRepository
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComicsRepositoryImpl(
    private val localDataSource: ComicsLocaDataSource,
    private val remoteDataSource: ComicsApiDataSource
): ComicsRepository {

    private val dispatcher = Dispatchers.IO

    override suspend fun getComics(limit: Int, offset: Int):
            Result<Failure, List<ComicEntity>> =
        withContext(dispatcher) {
            remoteDataSource.getComics(limit, offset)
        }
}