package com.wsl.domain.characters.usecases

import com.wsl.domain.ParamsUseCase
import com.wsl.domain.characters.CharactersRepository
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result

class GetCharacterUseCase(private val repository: CharactersRepository):
    ParamsUseCase<CharacterEntity, GetCharacterUseCase.Params>{

        override suspend fun invoke(params: Params): Result<Failure, CharacterEntity>
                = repository.getCharacter(params.id)


    data class Params(val id: Int)
}