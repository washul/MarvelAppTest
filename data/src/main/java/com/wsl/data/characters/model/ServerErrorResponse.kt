package com.wsl.data.characters.model

import com.google.gson.annotations.SerializedName

data class ServerErrorResponse (
    @SerializedName("code")
    val code: String,
    @SerializedName("status")
    val status: String
        )