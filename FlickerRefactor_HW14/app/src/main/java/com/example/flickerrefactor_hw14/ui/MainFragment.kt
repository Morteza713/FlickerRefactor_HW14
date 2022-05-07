package com.example.flickerrefactor_hw14.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickerrefactor_hw14.R
import com.example.flickerrefactor_hw14.data.model.Photo
import com.example.flickerrefactor_hw14.databinding.MainFragmentBinding
import com.example.flickerrefactor_hw14.viewmodel.MainFactory
import com.example.flickerrefactor_hw14.viewmodel.MainFragmentViewModel

class MainFragment:Fragment(R.layout.main_fragment) {

    lateinit var binding : MainFragmentBinding
    private val mainViewModel by viewModels<MainFragmentViewModel>(factoryProducer = {MainFactory()})

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)

        binding.rvMain.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if(!recyclerView.canScrollVertically(1))
                    mainViewModel.itemNewList().observe(viewLifecycleOwner) {
                        addAllList(it)
                    }
            }
        })
        mainViewModel.list.observe(viewLifecycleOwner, Observer {
            pushList(it)
        })
    }
    private fun pushList(list: List<Photo>) {
        ImageAdapter().pushPic(list)
        binding.rvMain.adapter = ImageAdapter()
        binding.rvMain.Recycler().setViewCacheSize(list.size - 1)
    }
    private fun addAllList(list: List<Photo>) {
        ImageAdapter().addAllPic(list)
        binding.rvMain.Recycler().setViewCacheSize(list.size - 1)
    }
}