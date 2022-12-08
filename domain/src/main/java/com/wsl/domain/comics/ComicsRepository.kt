package com.wsl.domain.comics

import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result

interface ComicsRepository {

    suspend fun getComics(limit: Int, offset: Int): Result<Failure, List<ComicEntity>>
}