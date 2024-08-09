package com.openinapp.presentation.main.links

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.openinapp.R
import com.openinapp.presentation._components.BasicButton
import com.openinapp.presentation.main.links._components.GreetingView
import com.openinapp.presentation.main.links._components.InfoCardsContainer
import com.openinapp.presentation.main.links._components.OverviewChart
import com.openinapp.presentation.main.links._components.TopBar

@Composable
fun LinksScreen() {

    val rootContainerScrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_secondary))
            .verticalScroll(rootContainerScrollState)
    ) {

        TopBar()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-24).dp)
                .background(
                    color = colorResource(R.color.background_secondary),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
        ) {

            GreetingView()
            OverviewChart()
            InfoCardsContainer()

            BasicButton(
                iconResourceId = R.drawable.growth,
                title = "View Analytics",
                onClick = {}
            )
        }

    }
}