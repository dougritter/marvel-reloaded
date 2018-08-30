package com.dougritter.marvel.features.characters

import android.os.Parcel
import com.dougritter.marvel.core.platform.KParcelable
import com.dougritter.marvel.core.platform.parcelableCreator

data class CharactersEntity(val data: CharacterBodyData) {
    fun toCharacters() = data.results

    companion object {
        fun empty() = CharactersEntity(CharacterBodyData(0, 0, 0, 0, emptyList()))
    }
}

data class CharacterBodyData(val offset: Int, val limit: Int, val total: Int,
                             val count: Int, val results: List<CharacterInfo>)

data class CharacterInfo(val id: Int, val name: String,
                         val description: String, val modified: String,
                         val thumbnail: Thumbnail, val resourceURI: String,
                         val comics: Comics, val series: Series,
                         val stories: Stories, val events: Events,
                         val urls: List<Url>)

data class Thumbnail(val path: String, val extension: String) : KParcelable {
    companion object {
        @JvmField val CREATOR = parcelableCreator(
                ::Thumbnail)
    }

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeString(path)
            writeValue(extension)
        }
    }
}

data class Comics(val available: Int, val collectionURI: String,
                  val items: List<ComicsItem>, val returned: Int)

data class ComicsItem(val resourceURI: String, val name: String)

data class Series(val available: Int, val collectionURI: String,
                  val items: List<SeriesItem>, val returned: Int)

data class SeriesItem(private val resourceURI: String, private val name: String)

data class Stories(private val available: Int, private val collectionURI: String,
                   private val items: List<StoriesItem>, private val returned: Int)

data class StoriesItem(private val resourceURI: String, private val name: String,
                       private val type: String)

data class Events(private val available: Int, private val collectionURI: String,
                  private val items: List<EventsItem>, private val returned: Int)

data class EventsItem(private val resourceURI: String, private val name: String)

data class Url(private val type: String, private val url: String)
