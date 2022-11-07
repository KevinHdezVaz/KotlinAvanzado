package com.alkemy.alkemybankbase.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinavanzado.api.apiResponsesStatus
import com.example.kotlinavanzado.model.User
import com.example.kotlinavanzado.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    private val _status = MutableLiveData<apiResponsesStatus<User>>()
    val status: LiveData<apiResponsesStatus<User>>
        get() = _status

    private val authrepository = AuthRepository()


    fun signUp(email:String, password:String, passwordConfirmation:String){
//para lanzar dentro de una corrutina
        viewModelScope.launch {
            _status.value = apiResponsesStatus.LOADING()
            handleResponseStatus(authrepository.signUp(email,password,passwordConfirmation))

        }
    }

    private fun handleResponseStatus(apiResponsesStatus: apiResponsesStatus<User>) {
        if(apiResponsesStatus is apiResponsesStatus.SUCCESS){
            _user.value = apiResponsesStatus.data!!
        }
        _status.value =apiResponsesStatus
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _status.value = apiResponsesStatus.LOADING()
            handleResponseStatus(authrepository.login(email,password))

        }
    }
}