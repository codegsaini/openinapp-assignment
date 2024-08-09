package com.openinapp.presentation.main.links

import com.openinapp.domain.model.DashboardData


data class LinksScreenState(
    val data: DashboardData = DashboardData(),
    val loading: Boolean = true,
    val error: String? = null
)