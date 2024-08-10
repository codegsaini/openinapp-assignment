package com.openinapp.presentation.main.links._components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openinapp.R

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontWeight = FontWeight(600),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            lineHeight = 24.sp
        )

        IconButton(
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = Color(0xFF2A80FF),
                    shape = RoundedCornerShape(10.dp)
                ),
            onClick = {}
        ) {
            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .aspectRatio(1f),
                painter = painterResource(R.drawable.wrench),
                contentDescription = "Settings icon",
                tint = Color.White
            )
        }
    }
}