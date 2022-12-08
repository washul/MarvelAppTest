package com.wsl.domain.characters.usecases

import com.wsl.domain.ParamsUseCase
import com.wsl.domain.UseCase
import com.wsl.domain.characters.CharactersRepository
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result

class GetAllCharactersUseCase(private val repository: CharactersRepository):
    ParamsUseCase<List<CharacterEntity>, GetAllCharactersUseCase.Params> {

    override suspend fun invoke(params: Params): Result<Failure, List<CharacterEntity>>
        = repository.getAllCharacters(params.limit, params.offset)

    data class Params(val limit: Int, val offset: Int)
}