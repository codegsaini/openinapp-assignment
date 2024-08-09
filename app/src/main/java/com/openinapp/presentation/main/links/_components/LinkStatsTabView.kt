package com.openinapp.presentation.main.links._components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.openinapp.R
import com.openinapp.presentation._components.BasicButton

enum class Tab { TOP_LINKS, RECENT_LINKS }

@Composable
fun LinkStatsTabView(
    modifier: Modifier = Modifier,
    activeTab: Tab,
    onTabChange: (Tab) -> Unit
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LazyRow(
            modifier = Modifier.weight(1f)
        ) {
            item {
                TabButton(
                    selected = activeTab == Tab.TOP_LINKS,
                    label = "Top Links",
                    onClick = { onTabChange(Tab.TOP_LINKS) }
                )
            }
            item {
                TabButton(
                    selected = activeTab == Tab.RECENT_LINKS,
                    label = "Recent Links",
                    onClick = { onTabChange(Tab.RECENT_LINKS) }
                )
            }
        }

        Icon(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.gray),
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable { }
                .padding(10.dp),
            painter = painterResource(R.drawable.search),
            contentDescription = null,
            tint = colorResource(R.color.text_secondary)
        )
    }
}

@Composable
fun TabButton(
    selected: Boolean,
    label: String,
    onClick: () -> Unit
) {
    val colors =
        if (selected)
            ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            )
        else
            ButtonDefaults.buttonColors(
                contentColor = colorResource(R.color.text_secondary),
                containerColor = Color.Transparent
            )

    BasicButton(
        modifier = Modifier,
        shape = RoundedCornerShape(40.dp),
        colors = colors,
        title = label,
        onClick = { onClick() }
    )
}