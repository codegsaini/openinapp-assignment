package com.openinapp.presentation.main._components

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.openinapp.presentation.main.links.LinksScreen

@Composable
fun BottomAppBarNavigationHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomAppBarScreens.LinksScreen.route
    ) {
        composable(BottomAppBarScreens.LinksScreen.route) {
            LinksScreen()
        }
        composable(BottomAppBarScreens.CoursesScreen.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Courses Screen")
            }
        }
        composable(BottomAppBarScreens.CampaignsScreen.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Campaigns Screen")
            }
        }
        composable(BottomAppBarScreens.ProfileScreen.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Profile Screen")
            }
        }
    }
}