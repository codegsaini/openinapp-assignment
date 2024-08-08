package com.openinapp.presentation.main._components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomAppBar(currentRoute: String, onNavigation: (String) -> Unit) {
    NavigationBar(
        modifier = Modifier.shadow(25.dp),
        containerColor = Color.White,
        windowInsets = WindowInsets.navigationBars
    ) {
        BottomAppBarScreens.screens.forEach { screen ->
            if (screen != null) {
                val isSelected = currentRoute == screen.route
                NavigationBarItem(
                    selected = isSelected,
                    onClick = { onNavigation(screen.route) },
                    label = {
                        Text(
                            text = stringResource(screen.label),
                            fontWeight = FontWeight(600),
                            fontSize = 11.sp
                        )
                    },
                    icon = {
                        val resId =
                            if (isSelected) screen.activeIconResourceId
                            else screen.inactiveIconResourceId
                        val tint =
                            if (isSelected) Color.Black
                            else Color(0xFF999CA0)

                        Image(
                            modifier = Modifier.size(19.dp),
                            painter = painterResource(resId),
                            contentDescription = stringResource(screen.label),
                            colorFilter = ColorFilter.tint(tint)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color(0xFF999CA0),
                        selectedTextColor = Color.Black,
                        unselectedTextColor = Color(0xFF999CA0),
                        indicatorColor = Color.Transparent
                    )
                )
            }
            else
                NavigationBarItem(selected = false, onClick = {}, icon = {}, enabled = false)
        }
    }
}