package com.example.flickerrefactor_hw14.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.data.network.CallbackService
import com.example.flickerrefactor_hw14.data.network.DataSource

class MainRepo(private val dataSource: DataSource) {


    fun photoList() : MutableLiveData<List<Photo>> {
        val photoList = MutableLiveData<List<Photo>>()
        dataSource.listPhoto(object : CallbackService<List<Photo>> {
            override fun onResponse(data: List<Photo>) {
                photoList.postValue(data)
            }
            override fun onFail(error: Throwable) {
                Log.d("fail" , "hi we are in mainRepo")
            }
        })
        return photoList
    }
    fun photoListPage(page:Int) : MutableLiveData<List<Photo>> {
        val photoList = MutableLiveData<List<Photo>>()
        dataSource.listPhotoPage(object : CallbackService<List<Photo>> {
            override fun onResponse(data: List<Photo>) {
                photoList.postValue(data)
            }
            override fun onFail(error: Throwable) {
                Log.d("fail" , "hi we are in mainRepo")
            }
        },page)
        return photoList
    }
}