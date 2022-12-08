package com.wsl.data.characters.mappers

import com.wsl.data.characters.model.MarvelServerResponse
import com.wsl.domain.characters.models.CharacterEntity

fun makeCharacterEntityMapperList(): (MarvelServerResponse) -> List<CharacterEntity> =
    { it.data.list }

fun makeCharacterEntityMapper(): (MarvelServerResponse) -> CharacterEntity =
    { it.data.list[0] ?: CharacterEntity() }
