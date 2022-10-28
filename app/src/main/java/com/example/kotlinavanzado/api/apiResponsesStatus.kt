package com.example.kotlinavanzado.api

import com.example.kotlinavanzado.dogList.DogList
import com.example.kotlinavanzado.model.Dog

sealed class apiResponsesStatus<T> {

    class SUCCESS<T>(val data: T): apiResponsesStatus<T>()
    class LOADING<T>:    apiResponsesStatus<T>()
    class ERROR<T>(val message: String): apiResponsesStatus<T>()


}