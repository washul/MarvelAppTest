package com.wsl.marvelapptest.common

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ThemeConfigManagement {

    private var toolBarColor: MutableLiveData<Int> = MutableLiveData<Int>(Color.WHITE)
    private var titleColor: MutableLiveData<Int> = MutableLiveData<Int>(Color.WHITE)
    private var backgroundPrimaryColor: MutableLiveData<Int> = MutableLiveData<Int>(Color.WHITE)

    fun getToolBarColor(): LiveData<Int> = toolBarColor
    fun getBackgroundPrimaryColor(): LiveData<Int> = backgroundPrimaryColor
    fun getTitleColor(): LiveData<Int> = titleColor

}