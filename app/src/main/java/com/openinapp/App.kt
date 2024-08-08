package com.openinapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navHostController = rememberNavController()

    // Main navigation (not the `BottomAppBar` navigation)
    NavigationHost(navHostController)
}