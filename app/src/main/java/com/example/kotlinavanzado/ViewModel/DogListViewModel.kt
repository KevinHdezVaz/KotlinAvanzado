package com.example.kotlinavanzado.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinavanzado.model.Dog
import com.example.kotlinavanzado.repository.DogRepository
import kotlinx.coroutines.launch

class DogListViewModel: ViewModel() {
    private val _doglist = MutableLiveData<List<Dog>>()
    val doglist: LiveData<List<Dog>>
    get() = _doglist

    private val dogRepository = DogRepository()
    //init sirve como constructor
    init {
downloadDogs()
    }
    private fun downloadDogs(){
        //viewmodelscope: Permite crear una corrutina en un VIEWMODEL
            viewModelScope.launch{
                _doglist.value = dogRepository.downloadDoags()
            }
    }

}