package com.openinapp.presentation.main.links

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openinapp.R
import com.openinapp.presentation.main.links._components.GreetingView
import com.openinapp.presentation.main.links._components.InfoCardsContainer
import com.openinapp.presentation.main.links._components.LinkStatsListView
import com.openinapp.presentation.main.links._components.LinkStatsTabView
import com.openinapp.presentation.main.links._components.OverviewChart
import com.openinapp.presentation.main.links._components.Tab
import com.openinapp.presentation.main.links._components.TopBar
import com.openinapp.presentation.main.links._components.TransparentActionButton
import com.openinapp.ui.theme.Figtree
import dashedBorder


@Composable
fun LinksScreen() {

    val rootContainerScrollState = rememberScrollState()
    val infoCardsContainerScrollState = rememberScrollState()

    var activeTab by remember { mutableStateOf(Tab.TOP_LINKS) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_secondary))
            .verticalScroll(rootContainerScrollState)
            .padding(bottom = 20.dp)
    ) {

        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(top = 40.dp)
                .padding(horizontal = 16.dp)
                .padding(bottom = 44.dp),
            title = "Dashboard"
        )

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

            GreetingView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .padding(horizontal = 16.dp),
                userName = "Ajay Manva"
            )

            OverviewChart(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .background(
                        colorResource(R.color.background_primary),
                        RoundedCornerShape(10.dp)
                    )
            )

            InfoCardsContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(infoCardsContainerScrollState)
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp),
                todayClicks = 123L,
                topLocation = "",
                topSource = ""
            )

            TransparentActionButton(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                iconResourceId = R.drawable.growth,
                title = "View Analytics",
                onClick = {}
            )

            LinkStatsTabView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .padding(horizontal = 16.dp),
                activeTab = activeTab,
                onTabChange = { activeTab = it }
            )

            LinkStatsListView(
                modifier = Modifier
                    .padding(top = 28.dp)
                    .padding(horizontal = 16.dp),
                items = emptyList()
            )

            TransparentActionButton(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                iconResourceId = R.drawable.link,
                title = "View all Links",
                onClick = {}
            )
        }

    }
}