package com.wsl.marvelapptest.base

import android.graphics.Color
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsl.marvelapptest.common.BaseScreenEvent
import com.wsl.marvelapptest.common.ThemeConfigManagement
import com.wsl.marvelapptest.utils.or
import com.wsl.utils.Failure
import org.koin.core.component.KoinComponent

abstract class BaseViewModel(
    private val themeConfigManagement : ThemeConfigManagement?
): ViewModel(), KoinComponent {

    private val defaultColor = MutableLiveData(Color.WHITE)
    private val defaultString = MutableLiveData("")

    protected fun showSnackbar(@StringRes stringRes: Int) =
        BaseScreenEvent.ShowSnackbar(stringRes)

    protected fun handleFailure(failure: Failure) {
        failure.logError()
        BaseScreenEvent.HandleFailure(failure)
    }

    fun getToolBarColor(): LiveData<Int> = themeConfigManagement?.getToolBarColor().or(defaultColor)
    fun getBackgroundPrimary(): LiveData<Int> =
        themeConfigManagement?.getBackgroundPrimaryColor().or(defaultColor)

    fun getSwimlineTitleColor(): LiveData<Int> =
        themeConfigManagement?.getTitleColor().or(defaultColor)
}