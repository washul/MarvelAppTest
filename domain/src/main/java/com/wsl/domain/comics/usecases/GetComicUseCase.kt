package com.wsl.domain.comics.usecases

import com.wsl.domain.ParamsUseCase
import com.wsl.domain.comics.ComicsRepository
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result

class GetComicUseCase(private val repository: ComicsRepository):
    ParamsUseCase<List<ComicEntity>, GetComicUseCase.Params> {

    override suspend fun invoke(params: Params): Result<Failure, List<ComicEntity>>
        = repository.getComics(params.limit, params.offset)


    data class Params(val limit: Int, val offset: Int)
}