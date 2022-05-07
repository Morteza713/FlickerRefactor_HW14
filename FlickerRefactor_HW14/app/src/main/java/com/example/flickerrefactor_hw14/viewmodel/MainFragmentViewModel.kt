package com.example.flickerrefactor_hw14.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.data.repository.MainRepo

class MainFragmentViewModel(private val mainRepo: MainRepo):ViewModel() {

    var list: LiveData<List<Photo>>
    var page: MutableLiveData<Int> = MutableLiveData<Int>(1)

    init {
        this.list = mainRepo.photoList()
    }

    fun itemNewList(): LiveData<List<Photo>> {
        page.value = page.value?.plus(1)
        return mainRepo.photoListPage(page.value!!)
    }

    fun plusPage() {
        page.value = page.value?.plus(1)
        itemNewList()
    }
}