package com.openinapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
    @SerialName("url_id")
    var id: Long,
    @SerialName("web_link")
    var webLink: String,
    @SerialName("smart_link")
    var smartLink: String,
    @SerialName("title")
    var title: String,
    @SerialName("total_clicks")
    var totalClicks: Long,
    @SerialName("original_image")
    var originalImage: String,
    @SerialName("thumbnail")
    var thumbnail: String,
    @SerialName("times_ago")
    var timesAgo: String,
    @SerialName("created_at")
    var createdAt: String,
    @SerialName("domain_id")
    var domainId: String,
    @SerialName("url_prefix")
    var urlPrefix: String,
    @SerialName("url_suffix")
    var urlSuffix: String,
    @SerialName("app")
    var app: String,
    @SerialName("is_favourite")
    var isFavourite: Boolean
)