package com.example.flickerrefactor_hw14.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flickerrefactor_hw14.data.network.RemoteData
import com.example.flickerrefactor_hw14.data.repository.MainRepo

class MainFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repo = MainRepo(RemoteData())
        return MainFragmentViewModel(repo) as T
    }
}