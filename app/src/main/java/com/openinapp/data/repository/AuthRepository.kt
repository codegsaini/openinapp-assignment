package com.openinapp.data.repository

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.openinapp.data._util.Response
import com.openinapp.data.service.AuthService
import kotlinx.coroutines.flow.firstOrNull

class AuthRepository(private val context: Context) {

    suspend fun login() : Response<String> {

        // This is a dummy login simulation can be changed later
        val response = Response.Success(AuthService().login())
        if (response is Response.Success) {
            PreferenceRepository(context)
                .setValue(stringPreferencesKey("access_token"), response.data)
        }
        return response
    }

}