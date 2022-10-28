package com.example.kotlinavanzado.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinavanzado.api.apiResponsesStatus
import com.example.kotlinavanzado.model.Dog
import com.example.kotlinavanzado.repository.DogRepository
import kotlinx.coroutines.launch

class DogListViewModel: ViewModel() {
    private val _doglist = MutableLiveData<List<Dog>>()
    val doglist: LiveData<List<Dog>>
    get() = _doglist

    private val _status = MutableLiveData<apiResponsesStatus<List<Dog>>>()
    val status: LiveData<apiResponsesStatus<List<Dog>>>
        get() = _status

    private val dogRepository = DogRepository()
    //init sirve como constructor
    init {
downloadDogs()
    }
    private fun downloadDogs(){
        //viewmodelscope: Permite crear una corrutina en un VIEWMODEL
            viewModelScope.launch{
                _status.value = apiResponsesStatus.LOADING()
                handleResponseStatus(dogRepository.downloadDoags())
             }
    }

    private fun handleResponseStatus(apiResponsesStatus: apiResponsesStatus<List<Dog>>) {
        if(apiResponsesStatus is apiResponsesStatus.SUCCESS){
            _doglist.value = apiResponsesStatus.data
        }
        _status.value =apiResponsesStatus
    }

}