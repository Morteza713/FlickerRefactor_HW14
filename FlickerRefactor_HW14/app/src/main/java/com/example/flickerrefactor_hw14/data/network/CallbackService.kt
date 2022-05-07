package com.example.flickerrefactor_hw14.data.network

interface CallbackService<T> {

    fun onResponse(data: T)
    fun onFail(error: Throwable)
}