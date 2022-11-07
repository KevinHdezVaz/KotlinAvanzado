package com.example.kotlinavanzado.repository

 import com.example.kotlinavanzado.api.DTO.LoginDTO
import com.example.kotlinavanzado.api.DTO.SignUpDto
import com.example.kotlinavanzado.api.DTO.UserDtoMapper
import com.example.kotlinavanzado.api.DogsApi.retrofitService
import com.example.kotlinavanzado.api.apiResponsesStatus
 import com.example.kotlinavanzado.api.makeNetworkCall
 import com.example.kotlinavanzado.model.User


class AuthRepository {
    //suspend fun se llama para mandar al metodo que esta DENTRO de la corrutina del viewmodel
    suspend fun login(email:String, password:String ): apiResponsesStatus<User> = makeNetworkCall{

        val loginDTO = LoginDTO(email,password)
        val loginresponse =  retrofitService.login(loginDTO)

        if(!loginresponse.isSucces){
            throw Exception(loginresponse.message)
        }
        val userDTO  = loginresponse.data.user
        val userDTOMapper = UserDtoMapper()
        userDTOMapper.fromDTOfromMain(userDTO)


    }
    suspend fun signUp(email:String, password:String,passwordConfirmation:String): apiResponsesStatus<User> = makeNetworkCall{

        val signUpDto = SignUpDto(email,password,passwordConfirmation)
        val signUpResponse =  retrofitService.signUp(signUpDto)

        if(!signUpResponse.isSucces){
            throw Exception(signUpResponse.message)
        }
        val userDTO  = signUpResponse.data.user
        val userDTOMapper = UserDtoMapper()
        userDTOMapper.fromDTOfromMain(userDTO)


    }

}