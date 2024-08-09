package com.openinapp.presentation.main.links._components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.openinapp.R
import com.openinapp.presentation._components.BasicButton

@Composable
fun TransparentActionButton(
    modifier: Modifier = Modifier,
    @DrawableRes
    iconResourceId: Int? = null,
    title: String,
    onClick: () -> Unit
) {
    BasicButton(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, colorResource(R.color.gray)),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onBackground,
            containerColor = Color.Transparent
        ),
        iconResourceId = iconResourceId,
        title = title,
        onClick = { onClick() }
    )
}
