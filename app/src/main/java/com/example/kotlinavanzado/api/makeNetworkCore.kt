package com.example.kotlinavanzado.api

 import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> makeNetworkCall(
    call: suspend() -> T
):apiResponsesStatus<T> = withContext(Dispatchers.IO){
        try {

            apiResponsesStatus.SUCCESS(call())
        }
        catch (e:Exception){
            apiResponsesStatus.ERROR("Error descargando los datos")
        }
    }

