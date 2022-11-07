package com.example.kotlinavanzado.api.DTO

import com.example.kotlinavanzado.model.Dog
import com.example.kotlinavanzado.model.User

class UserDtoMapper  {
    fun fromDTOfromMain(userDTO: UserDTO ): User {
        return User(userDTO.id, userDTO.email,userDTO.autenticationToken )
    }


}