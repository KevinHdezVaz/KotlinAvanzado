package com.alkemy.alkemybankbase.data.api.responses

import com.example.kotlinavanzado.api.responses.UserResponse
import com.squareup.moshi.Json

class AuthApiResponse (val message:String,
                       @field:Json(name="is_success") val isSucces:Boolean,
                       val data: UserResponse
) {
}