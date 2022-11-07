package com.example.kotlinavanzado.api.DTO

import com.squareup.moshi.Json

class SignUpDto(
    val email: String,
    val password: String,
    @field:Json(name = "password_confirmation") val passwordConfirmation: String
)