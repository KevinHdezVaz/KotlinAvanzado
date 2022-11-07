package com.example.kotlinavanzado.dogList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinavanzado.ViewModel.DogListViewModel
import com.example.kotlinavanzado.api.apiResponsesStatus
import com.example.kotlinavanzado.databinding.ActivityMainBinding
import com.example.kotlinavanzado.dogDetail.DogDetailActivity
import com.example.kotlinavanzado.dogDetail.DogDetailActivity.Companion.DOG_KEY
import com.example.kotlinavanzado.model.Dog

class DogList : AppCompatActivity() {
    private val doglistViewModel : DogListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

 //      val loadingWhell = binding.loadingWheel
   //      val recyclerView = binding.dogRecycler
     //   recyclerView.layoutManager = GridLayoutManager(this,3)
        val adapter = DogAdapter()
        adapter.setOnItemClickListener {
        //PASAR EL dog a DogDetailActivity
        val intent = Intent(this,DogDetailActivity::class.java)
        intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }
       // recyclerView.adapter = adapter

        doglistViewModel.doglist.observe(this){
            doglist ->
            adapter.submitList(doglist)
        }
        /*
        doglistViewModel.status.observe(this){
            status->

            when(status)
            {
                is apiResponsesStatus.ERROR ->
                {
                    Toast.makeText(this,status.message,Toast.LENGTH_SHORT).show()
         //           loadingWhell.visibility = View.GONE
                }
           //     is apiResponsesStatus.LOADING -> loadingWhell.visibility = View.VISIBLE
             //   is apiResponsesStatus.SUCCESS ->  loadingWhell.visibility = View.GONE

            }


        }*/
      }

}