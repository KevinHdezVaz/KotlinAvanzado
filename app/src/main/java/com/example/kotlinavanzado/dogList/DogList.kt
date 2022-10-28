package com.example.kotlinavanzado.dogList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinavanzado.ViewModel.DogListViewModel
import com.example.kotlinavanzado.databinding.ActivityMainBinding
import com.example.kotlinavanzado.model.Dog

class DogList : AppCompatActivity() {
    private val doglistViewModel : DogListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val recyclerView = binding.dogRecycler
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DogAdapter()
        recyclerView.adapter = adapter

        doglistViewModel.doglist.observe(this){
            doglist ->
            adapter.submitList(doglist)
        }
      }

}