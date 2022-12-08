package com.wsl.domain.characters

import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.utils.Failure
import com.wsl.utils.Result

interface CharactersRepository {

    suspend fun getAllCharacters(limit: Int, offset: Int):
            Result<Failure, List<CharacterEntity>>

    suspend fun getCharacter(id: Int):
            Result<Failure, CharacterEntity>

    suspend fun getCharacterComics(limit: Int, offset: Int, characterID: Int):
            Result<Failure, List<ComicEntity>>

}