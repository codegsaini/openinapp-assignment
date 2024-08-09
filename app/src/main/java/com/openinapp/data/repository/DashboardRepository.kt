package com.openinapp.data.repository

import android.util.Log
import com.openinapp.data._util.Response
import com.openinapp.data._util.ResponseHelper
import com.openinapp.data.service.DashboardService
import com.openinapp.domain.model.DashboardData

class DashboardRepository(private val dashboardService: DashboardService) {

    suspend fun getDashBoardData() : Response<DashboardData> {
        val response = ResponseHelper.handleResponseHelper<DashboardData> {
            dashboardService.getDashboardDataFromDatabase()
        }
        if (response is Response.Success) {
            Log.d("TTTG", "getDashBoardData: $response")
        }
        return response
    }

}