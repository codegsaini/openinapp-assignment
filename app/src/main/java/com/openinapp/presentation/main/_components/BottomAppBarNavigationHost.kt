package com.openinapp.presentation.main._components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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