package com.example.flickerrefactor_hw14.ui

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.flickerrefactor_hw14.R
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.databinding.SearchFragmentBinding
import com.example.flickerrefactor_hw14.viewmodel.SearchFactory
import com.example.flickerrefactor_hw14.viewmodel.SearchViewModel

class SearchFragment:Fragment(R.layout.search_fragment) {

    lateinit var binding: SearchFragmentBinding
    private val searchViewModel by viewModels<SearchViewModel>(factoryProducer = { SearchFactory() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SearchFragmentBinding.bind(view)

        searchViewModel.listPhotoSearch("").observe(viewLifecycleOwner,
            Observer {
                pushListData(it)
            })

        binding.tvSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchViewModel.listPhotoSearch(binding.tvSearch.query.toString()).observe(viewLifecycleOwner,
                    Observer {
                        pushListData(it)
                    })
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }
        })

    }
    fun pushListData(list : List<Photo>){
        ImageAdapter().pushPic(list)
        binding.rvSearch.adapter = ImageAdapter()
        binding.rvSearch.Recycler().setViewCacheSize(list.size - 1)
    }
}