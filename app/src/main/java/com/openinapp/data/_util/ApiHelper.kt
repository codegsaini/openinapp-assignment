package com.openinapp.data._util

class ApiHelper {
    companion object {
        private const val PROTOCOL = "http"
        private const val SECURE = true
        private const val HOST = "api.inopenapp.com"
        private const val API_VERSION = "v1"

        private val baseUrl =
            "${PROTOCOL}${SECURE.let { if (it) "s" else "" }}://$HOST/api/$API_VERSION"

        val dashboardApi = "$baseUrl/dashboardNew"
    }
}