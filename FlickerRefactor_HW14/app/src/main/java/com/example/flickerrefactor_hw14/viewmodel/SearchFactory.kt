package com.example.flickerrefactor_hw14.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flickerrefactor_hw14.data.network.RemoteData
import com.example.flickerrefactor_hw14.data.repository.SearchRepo

class SearchFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repo = SearchRepo(RemoteData())
        return SearchViewModel(repo) as T
    }
}