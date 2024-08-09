package com.openinapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.openinapp.presentation.main.MainScreen
import com.openinapp.presentation.main.links.LinksScreen
import dagger.hilt.android.HiltAndroidApp

sealed class Screen(val route: String) {
    data object MainScreen : Screen(route = "main_screen")
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}