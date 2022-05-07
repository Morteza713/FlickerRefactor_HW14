package com.example.flickerrefactor_hw14.data.model


data class Photos(
    val page: Int,
    val pages: Int,
    val perPage: Int,
    val photo: List<Photo>,
    val total: Int
)