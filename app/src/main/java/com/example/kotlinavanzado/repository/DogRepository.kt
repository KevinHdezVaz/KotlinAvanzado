package com.example.kotlinavanzado.repository

import com.example.kotlinavanzado.api.DogsApi.retrofitService
import com.example.kotlinavanzado.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
//suspend fun se llama para mandar al metodo que esta DENTRO de la corrutina del viewmodel

    suspend fun downloadDoags():List<Dog>{
//paara descargar archivos dentro de la corrutina
       return withContext(Dispatchers.IO){

          val dogListApiResponses =  retrofitService.getAllDogs()
           dogListApiResponses.data.dogs
        }
    }

}