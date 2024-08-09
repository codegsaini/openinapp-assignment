package com.openinapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DashboardData(
    @SerialName("support_whatsapp_number")
    val supportWhatsappNumber: String = "",
    @SerialName("extra_income")
    val extraIncome: Double = 0.0,
    @SerialName("total_links")
    val totalLinks: Long = 0,
    @SerialName("total_clicks")
    val totalClicks: Long = 0,
    @SerialName("today_clicks")
    val todayClicks: Long = 0,
    @SerialName("top_source")
    val topSource: String = "",
    @SerialName("top_location")
    val topLocation: String = "",
    @SerialName("startTime")
    val startTime: String = "",
    @SerialName("links_created_today")
    val linkCreatedToday: Int = 0,
    @SerialName("applied_campaign")
    val appliedCampaign: Long = 0,
    @SerialName("data")
    val data: Data = Data()
)

@Serializable
data class Data(
    @SerialName("recent_links")
    val recentLinks: List<Link> = emptyList(),
    @SerialName("top_links")
    val topLinks: List<Link> = emptyList(),
    @SerialName("favourite_links")
    val favouriteLinks: List<Link> = emptyList(),
)