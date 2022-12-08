package com.wsl.marvelapptest.layout.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.domain.characters.usecases.GetCharacterComicsUseCase
import com.wsl.domain.characters.usecases.GetCharacterUseCase
import com.wsl.domain.comics.models.ComicEntity
import com.wsl.marvelapptest.base.BaseViewModel
import com.wsl.marvelapptest.common.ThemeConfigManagement
import com.wsl.utils.onFailure
import com.wsl.utils.onSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase,
    private val characterID: Int,
    themeConfigManagement: ThemeConfigManagement
): BaseViewModel(
    themeConfigManagement
) {

    private val mutableCharacter = MutableLiveData<CharacterEntity>(CharacterEntity())
    var character = mutableCharacter

    private val mutableCharacterComics = MutableLiveData<List<ComicEntity>>(listOf())
    var comics = mutableCharacterComics

    val imagePath: LiveData<String> = Transformations.map(mutableCharacter) {
         "${it.thumbnail.path}.${it.thumbnail.extension}"
    }

    private val mutableShowLoading = MutableLiveData<Boolean>(false)
    var showLoading = mutableShowLoading

    init {
        getCharacter()
        getCharacterComics()
    }

    private fun getCharacter() {
        mutableShowLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO){
            getCharacterUseCase(
                GetCharacterUseCase.Params(
                    characterID
                )
            )
                .onFailure { /*handle failure*/ }
                .onSuccess {
                    mutableCharacter.postValue(it)
                    mutableShowLoading.postValue(false)
                }
        }
    }

    private fun getCharacterComics() {
        viewModelScope.launch(Dispatchers.IO) {
            getCharacterComicsUseCase(
                GetCharacterComicsUseCase.Params(
                    limit = 10,
                    offset = 0,
                    characterID = characterID
                )
            )
                .onFailure { /*Handle failure*/ }
                .onSuccess {
                    mutableCharacterComics.postValue(it)
                }
        }
    }

}