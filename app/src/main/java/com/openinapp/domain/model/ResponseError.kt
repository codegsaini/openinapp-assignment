package com.openinapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    val statusCode: Int,
    val message: String,
    val name: String,
    val errors: List<String>
)