package com.openinapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.openinapp.R

val FontFamily.Companion.Figtree: FontFamily
    get() = FontFamily(
        Font(R.font.figtree_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.figtree_light_italic, FontWeight.Light, FontStyle.Italic),

        Font(R.font.figtree_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.figtree_italic, FontWeight.Normal, FontStyle.Italic),

        Font(R.font.figtree_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.figtree_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),

        Font(R.font.figtree_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.figtree_bold_italic, FontWeight.Bold, FontStyle.Italic),

        Font(R.font.figtree_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(R.font.figtree_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),

        Font(R.font.figtree_black, FontWeight.Black, FontStyle.Normal),
        Font(R.font.figtree_black_italic, FontWeight.Black, FontStyle.Italic),
    )

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)