package com.example.kotlinavanzado.api.responses

import com.squareup.moshi.Json

class dogListApiResponses(  val message:String,
                            @field:Json(name="is_success") val isSucces:Boolean,
                          val data: dogListResponses) {
}