package com.example.flickerrefactor_hw14.data.model


data class Photo(
    val farm: Int,
    val height_s: Int,
    val id: String,
    val isFamily: Int,
    val isFriend: Int,
    val isPublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    val url_s: String,
    val width_s: Int
)