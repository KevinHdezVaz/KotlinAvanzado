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

        private fun getFakeDogs(): MutableList<Dog> {
            val dogList = mutableListOf<Dog>()
            dogList.add(
                Dog(
                    1, 1, "Chihuahua", "Toy", 5.4,
                    6.7, "", "12 - 15", "", 10.5,
                    12.3
                )
            )
            dogList.add(
                Dog(
                    2, 1, "Labrador", "Toy", 5.4,
                    6.7, "", "12 - 15", "", 10.5,
                    12.3
                )
            )
            dogList.add(
                Dog(
                    3, 1, "Retriever", "Toy", 5.4,
                    6.7, "", "12 - 15", "", 10.5,
                    12.3
                )
            )
            dogList.add(
                Dog(
                    4, 1, "San Bernardo", "Toy", 5.4,
                    6.7, "", "12 - 15", "", 10.5,
                    12.3
                )
            )
            dogList.add(
                Dog(
                    5, 1, "Husky", "Toy", 5.4,
                    6.7, "", "12 - 15", "", 10.5,
                    12.3
                )
            )
            dogList.add(
                Dog(
                    6, 1, "Xoloscuincle", "Toy", 5.4,
                    6.7, "", "12 - 15", "", 10.5,
                    12.3
                )
            )
            return dogList
        }
}