package com.example.flickerrefactor_hw14.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.data.repository.SearchRepo


class SearchViewModel(private val searchRepo : SearchRepo):ViewModel() {

    fun listPhotoSearch(text:String): LiveData<List<Photo>> {
        return searchRepo.photoList(text)
    }
}