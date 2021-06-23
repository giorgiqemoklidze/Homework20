package com.example.homework20.models

data class News(
    val events: List<Event>?,
    val featured: Boolean?,
    val id: Int?,
    val imageUrl: String?,
    val launches: List<Launches>?,
    val newsSite: String?,
    val publishedAt: String?,
    val summary: String?,
    val title: String?,
    val updatedAt: String?,
    val url: String?
){
    data class Event(
           val  id: String?,
           val provider : String
    )

    data class Launches(
            val  id: String?,
            val provider : String
    )

}