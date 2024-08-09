package com.openinapp.presentation.main.links

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.openinapp.R
import com.openinapp.presentation.main.links._components.AlertPopup
import com.openinapp.presentation.main.links._components.CardButton
import com.openinapp.presentation.main.links._components.GreetingView
import com.openinapp.presentation.main.links._components.InfoCardsContainer
import com.openinapp.presentation.main.links._components.LinkStatsListView
import com.openinapp.presentation.main.links._components.LinkStatsTabView
import com.openinapp.presentation.main.links._components.LoadingWidget
import com.openinapp.presentation.main.links._components.OverviewChart
import com.openinapp.presentation.main.links._components.Tab
import com.openinapp.presentation.main.links._components.TopBar
import com.openinapp.presentation.main.links._components.TransparentActionButton
import com.openinapp.ui.theme.Figtree
import dashedBorder


@Composable
fun LinksScreen(
    viewModel: LinksScreenViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    val rootContainerScrollState = rememberScrollState()
    val infoCardsContainerScrollState = rememberScrollState()

    var activeTab by remember { mutableStateOf(Tab.TOP_LINKS) }

    viewModel.error?.let { error ->
        AlertPopup(message = error) {
            viewModel.onEvent(LinksScreenEvent.OnDismissError)
        }
    }

    if (viewModel.loading) {
        LoadingWidget()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_secondary))
            .verticalScroll(rootContainerScrollState)
    ) {

        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(top = 40.dp)
                .padding(horizontal = 16.dp)
                .padding(bottom = 44.dp),
            title = "Dashboard",
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
                userName = viewModel.userName
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
                todayClicks = viewModel.dashBoardData.todayClicks,
                topLocation = viewModel.dashBoardData.topLocation,
                topSource = viewModel.dashBoardData.topSource
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
                items = if (activeTab == Tab.TOP_LINKS) viewModel.topLinks else viewModel.recentLinks,
                context = context,
                clipboardManager = clipboardManager
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

            CardButton(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, colorResource(R.color.light_green), RoundedCornerShape(10.dp))
                    .background(colorResource(R.color.light_green), RoundedCornerShape(10.dp))
                    .clickable {  }
                    .padding(vertical = 20.dp, horizontal = 12.dp),
                iconResourceId = R.drawable.wp,
                title = "Chat with us"
            )
            CardButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(1.dp, colorResource(R.color.light_blue), RoundedCornerShape(10.dp))
                    .background(colorResource(R.color.lighter_blue), RoundedCornerShape(10.dp))
                    .clickable {  }
                    .padding(vertical = 20.dp, horizontal = 12.dp),
                iconResourceId = R.drawable.faq,
                title = "Frequently Asked Questions"
            )
        }

    }
}