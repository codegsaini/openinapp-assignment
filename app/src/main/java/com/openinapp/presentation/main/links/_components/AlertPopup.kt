package com.openinapp.presentation.main.links._components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.openinapp.R
import com.openinapp.ui.theme.Figtree

@Composable
fun AlertPopup(message: String, onDismissRequest: () -> Unit) {
    Popup(
        alignment = Alignment.Center,
        properties = PopupProperties(
            clippingEnabled = true,
            dismissOnClickOutside = true,
            dismissOnBackPress = true
        ),
        onDismissRequest = { onDismissRequest() }
    ) {
        Column(
            modifier = Modifier
                .width(250.dp)
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .background(Color.White, RoundedCornerShape(10.dp))
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                text = "Error",
                fontSize = 18.sp,
                fontFamily = FontFamily.Figtree,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(colorResource(R.color.gray))
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                text = message,
                fontSize = 16.sp,
                fontFamily = FontFamily.Figtree,
                textAlign = TextAlign.Center
            )
        }
    }
}