package com.wsl.domain.characters.usecases

import com.wsl.domain.ParamsUseCase
import com.wsl.domain.characters.CharactersRepository
import com.wsl.domain.comics.ComicsRepository
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result

class GetCharacterComicsUseCase(private val repository: CharactersRepository):
    ParamsUseCase<List<ComicEntity>, GetCharacterComicsUseCase.Params> {

        override suspend fun invoke(params: Params): Result<Failure, List<ComicEntity>>
                = repository.getCharacterComics(params.limit, params.offset, params.characterID)

    data class Params(val limit: Int, val offset: Int, val characterID: Int)
}