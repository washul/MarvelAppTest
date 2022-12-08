package com.wsl.data.characters.model

import com.google.gson.annotations.SerializedName
import com.wsl.domain.characters.models.CharacterEntity

data class MarvelServerResponse (
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("status")
    val status: String = "",
    @SerializedName("copyright")
    val copyright: String = "",
    @SerializedName("attributionText")
    val attributionText: String = "",
    @SerializedName("attributionHTML")
    val attributionHTML: String = "",
    @SerializedName("etag")
    val etag: String = "",
    @SerializedName("data")
    val data: CharacterDataResponse = CharacterDataResponse()
    )

data class CharacterDataResponse(
    @SerializedName("offset")
    val offset: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val list: List<CharacterEntity> = listOf()
)




