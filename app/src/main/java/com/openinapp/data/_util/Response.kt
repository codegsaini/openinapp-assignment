package com.openinapp.data._util

import com.openinapp.domain.model.ResponseError

sealed class Response <out T: Any> {
    data class Success<out T: Any>(val data: T) : Response<T>()
    data class Failure(val error: ResponseError) : Response<Nothing>()
}