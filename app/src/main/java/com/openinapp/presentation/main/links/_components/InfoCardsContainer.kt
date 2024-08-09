package com.openinapp.presentation.main.links._components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openinapp.R
import com.openinapp.ui.theme.Figtree

@Composable
fun InfoCardsContainer(
    modifier: Modifier = Modifier,
    todayClicks: Long,
    topLocation: String,
    topSource: String
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        InfoCard(
            iconResourceId = R.drawable.cursor,
            label = "Today's Clicks",
            value = todayClicks.toString()
        )
        InfoCard(
            iconResourceId = R.drawable.location,
            label = "Top Location",
            value = topLocation
        )
        InfoCard(
            iconResourceId = R.drawable.globe,
            label = "Top source",
            value = topSource
        )
    }
}

@Composable
fun InfoCard(
    @DrawableRes
    iconResourceId: Int,
    label: String,
    value: String
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .background(
                color = colorResource(R.color.background_primary),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(12.dp)
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(iconResourceId),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Figtree,
            lineHeight = 16.sp,
            color = colorResource(R.color.text_primary),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            text = label,
            fontSize = 14.sp,
            fontFamily = FontFamily.Figtree,
            lineHeight = 20.sp,
            color = colorResource(R.color.text_secondary),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}