package com.openinapp.presentation.main._components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.openinapp.R

sealed class BottomAppBarScreens(
    @StringRes
    val label: Int,
    val route: String,
    @DrawableRes
    val activeIconResourceId: Int,
    @DrawableRes
    val inactiveIconResourceId: Int
) {
    companion object {
        val screens = listOf(
            LinksScreen,
            CoursesScreen,
            null,
            CampaignsScreen,
            ProfileScreen
        )
    }

    data object LinksScreen : BottomAppBarScreens(
        label = R.string.links_route_label,
        route = "links_screen",
        activeIconResourceId = R.drawable.link,
        inactiveIconResourceId = R.drawable.link
    )

    data object CoursesScreen : BottomAppBarScreens(
        label = R.string.courses_route_label,
        route = "courses_screen",
        activeIconResourceId = R.drawable.magazine,
        inactiveIconResourceId = R.drawable.magazine
    )

    data object CampaignsScreen : BottomAppBarScreens(
        label = R.string.campaigns_route_label,
        route = "campaigns_screen",
        activeIconResourceId = R.drawable.campaign,
        inactiveIconResourceId = R.drawable.campaign
    )

    data object ProfileScreen : BottomAppBarScreens(
        label = R.string.profile_route_label,
        route = "profile_screen",
        activeIconResourceId = R.drawable.user,
        inactiveIconResourceId = R.drawable.user
    )

}