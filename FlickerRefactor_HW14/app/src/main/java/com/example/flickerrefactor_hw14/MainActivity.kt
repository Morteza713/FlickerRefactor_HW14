package com.example.flickerrefactor_hw14

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.flickerrefactor_hw14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment_container) }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        NavigationUI.setupActionBarWithNavController(this, navController )

        binding.btnNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mainFragment -> {
                    navController.navigate(R.id.mainFragment)
                } R.id.searchFragment -> {
                navController.navigate(R.id.searchFragment)
            }
            }
            true
        }

    }
}