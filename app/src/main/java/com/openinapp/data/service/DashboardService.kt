package com.openinapp.data.service

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.stringPreferencesKey
import com.openinapp.data._util.ApiHelper
import com.openinapp.data.repository.PreferenceRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.flow.firstOrNull

class DashboardService(
    private val context: Context,
    private val client: HttpClient
) {

    suspend fun getDashboardDataFromDatabase() : HttpResponse {

        val token = PreferenceRepository(context)
            .getValue(stringPreferencesKey("access_token"))
            .firstOrNull()

        return client.get(ApiHelper.dashboardApi) {
            header("Authorization", "Bearer $token")
        }
    }

}