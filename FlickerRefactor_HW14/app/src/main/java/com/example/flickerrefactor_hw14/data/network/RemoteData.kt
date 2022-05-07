package com.example.flickerrefactor_hw14.data.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.data.model.PhotoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteData(): DataSource {

    override fun listPhoto(callback: CallbackService<List<Photo>>) {

        val apiKey = "1c04e05bce6e626247758d120b372a73"
        val method = "flickr.photos.getPopular"
        val userId = "34427466731@N01"
        val extras = "url_s"
        val format = "json"
        val nojsoncallback = "1"
        val perPage = "5"
        val page = 1

        var lists:List<Photo>? = null
        NetworkManager.service.loadImages(
            apiKey,
            userId,
            method,
            extras,
            format,
            nojsoncallback,
            perPage,
            page.toString()
        ).enqueue(object : Callback<PhotoModel> {
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    lists = response.body()!!.photos.photo
                    callback.onResponse(lists!!)
                }
            }
            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {
                t.message?.let { Log.d("Response", "onFailure$it") }
                callback.onFail(t)
            }
        })
    }
    override fun listPhotoSearch(callback: CallbackService<List<Photo>>, text:String) {

        val apiKey = "1c04e05bce6e626247758d120b372a73"
        val method = "flickr.photos.Search"
        val userId = "34427466731@N01"
        val extras = "url_s"
        val format = "json"
        val nojsoncallback = "1"
        val perPage = "30"
        val page = "1"
        val tempLive = MutableLiveData<List<Photo>>()
        var lists:List<Photo>? = null
        NetworkManager.service.loadSearches(
            apiKey,
            userId,
            method,
            extras,
            format,
            nojsoncallback,
            perPage,
            page ,
            text
        ).enqueue(object : Callback<PhotoModel> {
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    lists = response.body()!!.photos.photo
                    callback.onResponse(lists!!)
                }
            }
            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {
                t.message?.let { Log.d("Response", "onFailure$it") }
                callback.onFail(t)
            }
        })
    }

    override fun listPhotoPage(
        callback: CallbackService<List<Photo>>,
        page: Int
    ) {
        val apiKey = "1c04e05bce6e626247758d120b372a73"
        val method = "flickr.photos.getPopular"
        val userId = "34427466731@N01"
        val extras = "url_s"
        val format = "json"
        val nojsoncallback = "1"
        val perPage = "5"

        var lists:List<Photo>?
        NetworkManager.service.loadImages(
            apiKey,
            userId,
            method,
            extras,
            format,
            nojsoncallback,
            perPage,
            page.toString()
        ).enqueue(object : Callback<PhotoModel> {
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("onResponse Ok " , page.toString())
                    Log.d("onResponse Ok " , response.body()!!.photos.photo.toString())
                    lists = response.body()!!.photos.photo
                    callback.onResponse(lists!!)
                }
            }
            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {
                t.message?.let { Log.d("Response", "onFailure$it") }
                callback.onFail(t)
            }
        })
    }

}