package com.wsl.domain.characters.models

import com.google.gson.annotations.SerializedName

data class CharacterEntity(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("resourceURI")
    val resourceURI: String ="",
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail = Thumbnail(),
    @SerializedName("comics")
    val comics: CharactersAppearance = CharactersAppearance(),
    @SerializedName("series")
    val series: CharactersAppearance = CharactersAppearance(),
    @SerializedName("stories")
    val stories: CharactersAppearance = CharactersAppearance(),
    @SerializedName("event")
    val event: CharactersAppearance = CharactersAppearance()
) {
    data class CharactersAppearance(
        @SerializedName("available") val available: Int = 0,
        @SerializedName("collectionURI") val collectionURI: String? = "",
        @SerializedName("items") val items: List<AppearanceItem> = listOf()
    )

    data class AppearanceItem(
        @SerializedName("resourceURI") val resourceURI: String? = "",
        @SerializedName("name") val name: String? = "",
        @SerializedName("type") val type: String? =""
    )


}

data class Thumbnail (
    @SerializedName("path")
    val path: String = "",
    @SerializedName("extension")
    val extension: String = ""
)



