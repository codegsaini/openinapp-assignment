package com.openinapp.presentation.main.links._components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.openinapp.domain.model.Link
import com.openinapp.ui.theme.Figtree
import dashedBorder

@Composable
fun LinkStatsListView(
    modifier: Modifier = Modifier,
    items: List<Link>
) {
    Column(modifier = modifier) {
        items.forEach { link ->
            LinkStatItem(link)
        }
    }
}

@Composable
private fun LinkStatItem(link: Link) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 5.dp,
                spotColor = Color(0xFFEFEFEF),
                ambientColor = Color(0xFFEFEFEF),
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = colorResource(R.color.background_primary),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = colorResource(R.color.background_secondary),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = link.title,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Figtree,
                    lineHeight = 24.sp,
                    color = colorResource(R.color.text_primary)
                )
                Text(
                    text = link.createdAt,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Figtree,
                    lineHeight = 18.sp,
                    color = colorResource(R.color.text_secondary)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = link.totalClicks.toString(),
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Figtree,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 24.sp,
                    color = colorResource(R.color.text_primary)
                )
                Text(
                    text = "Clicks",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Figtree,
                    lineHeight = 18.sp,
                    color = colorResource(R.color.text_secondary)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .dashedBorder(
                    width = 1.dp,
                    color = colorResource(R.color.primary_light),
                    shape = RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp),
                    on = 2.dp,
                    off = 2.dp
                )
                .background(colorResource(R.color.primary_lighter))
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = link.webLink,
                fontSize = 14.sp,
                fontFamily = FontFamily.Figtree,
                lineHeight = 16.sp,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(R.color.primary)
            )
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { /*TODO: Write function to copy link to clipboard*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .aspectRatio(1f),
                    painter = painterResource(R.drawable.copy),
                    contentDescription = null,
                    tint = colorResource(R.color.primary)
                )
            }
        }
    }
}