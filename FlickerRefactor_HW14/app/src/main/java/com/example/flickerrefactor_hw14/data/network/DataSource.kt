package com.example.flickerrefactor_hw14.data.network

import com.example.flickerrefactor_hw14.data.model.Photo

interface DataSource {

    fun listPhoto(callback: CallbackService<List<Photo>>)
    fun listPhotoSearch(callback: CallbackService<List<Photo>>, text: String)
    fun listPhotoPage(callback: CallbackService<List<Photo>>, page: Int)

}