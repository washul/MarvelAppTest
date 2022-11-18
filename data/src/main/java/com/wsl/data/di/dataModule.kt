package com.wsl.data.di

import com.wsl.data.*
import com.wsl.data.characters.repository.CharactersApiDataSource
import com.wsl.data.characters.repository.CharactersLocalDataSource
import com.wsl.data.characters.repository.CharactersRepositoryImpl
import com.wsl.domain.characters.CharactersRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val RETROFIT_CLIENT = "RetrofitClient"

val dataModule = module {
    single<CharactersRepository> { CharactersRepositoryImpl( get(), get() ) }
    single { CharactersLocalDataSource() }
    single { CharactersApiDataSource( get() ) }

    //Retrofit
    factory { provideService( get(named(RETROFIT_CLIENT)) ) }
    single(named(RETROFIT_CLIENT)) { provideRetrofit( get(named("plainOkHttpClient")), get() ) }
    single { provideGsonInstance() }

    factory(named("plainOkHttpClient")) { providePlainOkHttpClient() }
    factory(named("sessionCookieJar")) { provideCookieJar() }
}