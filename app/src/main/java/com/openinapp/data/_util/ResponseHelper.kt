package com.openinapp.data._util

import android.util.Log
import com.openinapp.domain.model.ResponseError
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResponseHelper {

    companion object {

        val TAG = "ResponseHelper"

        suspend inline fun <reified T: Any> handleResponseHelper(
            crossinline execute: suspend () -> HttpResponse
        ) : Response<T> {
            return try {
                val response = withContext(Dispatchers.IO) { execute() }
                val result = response.body<T>()
                Response.Success(result)
            } catch (e: ClientRequestException) {
                Log.e(TAG, "handleResponseHelper: ${e.localizedMessage}")
                Response.Failure(e.response.body<ResponseError>())
            } catch (e: ServerResponseException) {
                Log.e(TAG, "handleResponseHelper: ${e.localizedMessage}")
                Response.Failure(
                    ResponseError(
                        statusCode = e.response.status.value,
                        message = e.localizedMessage ?: e.message,
                        name = "SERVER_ERROR",
                        errors = emptyList()
                    )
                )
            } catch (e: Exception) {
                Log.e(TAG, "handleResponseHelper: ${e.localizedMessage}")
                if (e is CancellationException) throw e
                Response.Failure(
                    ResponseError(
                        statusCode = 0,
                        message = e.localizedMessage ?: e.message ?: "Something went wrong",
                        name = "EXCEPTION",
                        errors = emptyList()
                    )
                )
            }
        }
    }

}