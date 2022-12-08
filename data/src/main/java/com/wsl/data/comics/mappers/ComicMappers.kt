package com.wsl.data.comics.mappers

import com.wsl.data.comics.model.ComicServerResponse
import com.wsl.domain.comics.models.ComicEntity

fun makeComicListFromResponse(): (ComicServerResponse) -> List<ComicEntity> =
    {response -> response.data.list.map { it }}