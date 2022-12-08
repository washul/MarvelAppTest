package com.wsl.marvelapptest.common

import androidx.annotation.StringRes
import com.wsl.utils.Failure

sealed class BaseScreenEvent {
    data class ShowSnackbar(@StringRes val msg: Int) : BaseScreenEvent()
    data class HandleFailure(val failure: Failure) : BaseScreenEvent()
}