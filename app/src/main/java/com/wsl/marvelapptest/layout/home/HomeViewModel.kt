package com.wsl.marvelapptest.layout.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsl.domain.characters.models.CharacterEntity
import com.wsl.domain.characters.usecases.GetAllCharactersUseCase
import com.wsl.marvelapptest.base.BaseViewModel
import com.wsl.marvelapptest.common.ThemeConfigManagement
import com.wsl.marvelapptest.utils.addList
import com.wsl.utils.onFailure
import com.wsl.utils.onSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    themeConfigManagement: ThemeConfigManagement
): BaseViewModel(
    themeConfigManagement
) {

    private val mutableCharactersList = MutableLiveData<List<CharacterEntity>>(emptyList())
    var charactersList = mutableCharactersList

    private val mutableShowLoading = MutableLiveData<Boolean>(false)
    var showLoading = mutableShowLoading

    private var offsetItemCount = 0
    private val limitCharactersItems = 10

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        mutableShowLoading.postValue(true)
        offsetItemCount += mutableCharactersList.value!!.size

        viewModelScope.launch(Dispatchers.IO) {
            getAllCharactersUseCase(
                GetAllCharactersUseCase.Params(
                    limit = limitCharactersItems,
                    offset = offsetItemCount
                )
            )
                .onFailure{ Log.e("Error", it.getError() ?: "") }
                .onSuccess {
                    mutableCharactersList.addList(it)
                    mutableShowLoading.postValue(false)
                }
        }
    }

}