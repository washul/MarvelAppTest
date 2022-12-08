package com.wsl.data.comics.model

import com.google.gson.annotations.SerializedName
import com.wsl.domain.comics.models.ComicEntity

data class ComicServerResponse (
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
    val data: ComicDataResponse = ComicDataResponse()
)

data class ComicDataResponse(
    @SerializedName("offset")
    val offset: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val list: List<ComicEntity> = listOf()
)
