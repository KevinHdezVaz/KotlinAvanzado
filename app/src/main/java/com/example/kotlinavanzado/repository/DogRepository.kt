package com.example.kotlinavanzado.repository

 import com.example.kotlinavanzado.api.DTO.DogDTOPMapper
import com.example.kotlinavanzado.api.DogsApi.retrofitService
import com.example.kotlinavanzado.api.apiResponsesStatus
 import com.example.kotlinavanzado.api.makeNetworkCall
 import com.example.kotlinavanzado.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
//suspend fun se llama para mandar al metodo que esta DENTRO de la corrutina del viewmodel

    suspend fun downloadDoags():apiResponsesStatus<List<Dog>> = makeNetworkCall{
//paara descargar archivos dentro de la corrutina

           val dogListApiResponses =  retrofitService.getAllDogs()
           val dogDtoList = dogListApiResponses.data.dogs
           val dogDTOPMapper = DogDTOPMapper()
           dogDTOPMapper.fromDogDTOListToDogDomainList(dogDtoList)


    }

}