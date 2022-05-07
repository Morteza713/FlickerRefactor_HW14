package com.example.flickerrefactor_hw14.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.data.network.CallbackService
import com.example.flickerrefactor_hw14.data.network.DataSource

class SearchRepo(private val dataSourceSearch: DataSource)  {


    fun photoList(text:String) : MutableLiveData<List<Photo>> {
        val temp = MutableLiveData<List<Photo>>()
        dataSourceSearch.listPhotoSearch(object : CallbackService<List<Photo>> {
            override fun onResponse(data: List<Photo>) {
                temp.postValue(data)
            }
            override fun onFail(error: Throwable) {
                Log.d("fail" , "hi we are in searchRepo")

            }
        },text)
        return temp
    }
}