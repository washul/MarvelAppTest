package com.wsl.domain.comics.models

import com.google.gson.annotations.SerializedName
import com.wsl.domain.characters.models.Thumbnail

data class ComicEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("digitalId") val digitalId: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("issueNumber") val issueNumber: Double? = null,
    @SerializedName("variantDescription") val variantDescription: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("modified") val modified: String? = null,
    @SerializedName("isbn") val isbn: String? = null,
    @SerializedName("upc") val upc: String? = null,
    @SerializedName("diamondCode") val diamondCode: String? = null,
    @SerializedName("ean") val ean: String? = null,
    @SerializedName("issn") val issn: String? = null,
    @SerializedName("format") val format: String? = null,
    @SerializedName("pageCount") val pageCount: Int? = null,
    @SerializedName("textObjects") val textObjects: List<TextObjects> = listOf(),
    @SerializedName("resourceURI") val resourceURI: String? = null,
    @SerializedName("urls") val urls: List<ComicURL> = listOf(),
    @SerializedName("comicSeries") val comicSeries: ComicSeries? = null,
    @SerializedName("thumbnail") val thumbnail: Thumbnail = Thumbnail(),
    @SerializedName("ComicVariant") val ComicVariant: List<ComicVariants> = listOf(),
    @SerializedName("comicCreators") val comicCreators: List<ComicCreator> = listOf(),
    @SerializedName("comicCharacters") val comicCharacters: List<ComicCharacter> = listOf(),
    @SerializedName("comicStory") val comicStory: List<ComicStory> = listOf(),
    @SerializedName("comicEvent") val comicEvent: List<ComicEvent> = listOf()
) {

    data class ComicCreator(
        @SerializedName("available") val available: Int? = null,
        @SerializedName("collectionURI") val collectionURI: String? = null,
        @SerializedName("items") val items: String? = null,
        @SerializedName("returned") val returned: String? = null
    )
    data class ComicCharacter(
        @SerializedName("available") val available: Int? = null,
        @SerializedName("collectionURI") val collectionURI: String? = null,
        @SerializedName("items") val items: String? = null,
        @SerializedName("returned") val returned: String? = null
    )
    data class ComicStory(
        @SerializedName("available") val available: Int? = null,
        @SerializedName("collectionURI") val collectionURI: String? = null,
        @SerializedName("items") val items: String? = null,
        @SerializedName("returned") val returned: String? = null
    )
    data class ComicEvent(
        @SerializedName("available") val available: Int? = null,
        @SerializedName("collectionURI") val collectionURI: String? = null,
        @SerializedName("items") val items: String? = null,
        @SerializedName("returned") val returned: String? = null
    )

    data class ComicCreatorItem(
        @SerializedName("resourceURI") val resourceURI: String? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("role") val role: String? = null
    )

    data class ComicVariants(
        @SerializedName("resourceURI") val resourceURI: String? = null,
        @SerializedName("name") val name: String? = null
    )

    data class ComicSeries(
        @SerializedName("resourceURI") val resourceURI: String? = null,
        @SerializedName("name") val name: String? = null
    )

    data class ComicURL(
        @SerializedName("type") val type: String,
        @SerializedName("url") val url: String
    )

    data class TextObjects (
        @SerializedName("type") val type: String = "",
        @SerializedName("language") val language: String = "",
        @SerializedName("text") val text: String = ""
    )

}