package com.dougritter.marvel.features.characters

data class CharactersEntity(private val data: CharacterBodyData)

data class CharacterBodyData(private val offset: Int, private val limit: Int, private val total: Int,
                             private val count: Int, private val results: List<CharacterInfo>)

data class CharacterInfo(private val id: Int, private val name: String,
                         private val description: String, private val modified: String,
                         private val thumbnail: Thumbnail, private val resourceURI: String,
                         private val comics: Comics, private val series: Series,
                         private val stories: Stories, private val events: Events,
                         private val urls: List<Url>)

data class Thumbnail(private val path: String, private val extension: String)

data class Comics(private val available: Int, private val collectionURI: String,
                  private val items: List<ComicsItem>, private val returned: Int)

data class ComicsItem(private val resourceURI: String, private val name: String)

data class Series(private val available: Int, private val collectionURI: String,
                  private val items: List<SeriesItem>, private val returned: Int)

data class SeriesItem(private val resourceURI: String, private val name: String)

data class Stories(private val available: Int, private val collectionURI: String,
                   private val items: List<StoriesItem>, private val returned: Int)

data class StoriesItem(private val resourceURI: String, private val name: String,
                       private val type: String)

data class Events(private val available: Int, private val collectionURI: String,
                  private val items: List<EventsItem>, private val returned: Int)

data class EventsItem(private val resourceURI: String, private val name: String)

data class Url(private val type: String, private val url: String)
