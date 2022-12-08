package com.wsl.domain.di

import com.wsl.domain.characters.usecases.GetAllCharactersUseCase
import com.wsl.domain.characters.usecases.GetCharacterUseCase
import com.wsl.domain.characters.usecases.GetCharacterComicsUseCase
import com.wsl.domain.comics.usecases.GetComicUseCase
import org.koin.dsl.module

val DomainModule = module {
    factory { GetAllCharactersUseCase(get()) }
    factory { GetCharacterUseCase(get()) }
    factory { GetCharacterComicsUseCase(get()) }
    factory { GetComicUseCase(get()) }
}