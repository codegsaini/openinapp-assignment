package com.openinapp.presentation._util

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BottomAppBarShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(path = getPath(size.width, size.height))
    }
}

fun getPath(width: Float, height: Float) : Path {
    return Path().apply {
        reset()
        moveTo(0f, height)
        lineTo(0f, 0f)
        lineTo(width * 0.35f, 0f)
        cubicTo(
            width * 0.43f, 0f,
            width * 0.43f, height * -0.21f,
            width * 0.5f, height * -0.21f
        )
        lineTo(width * 0.5f, height * -0.21f)
        cubicTo(
            width * 0.57f, height * -0.21f,
            width * 0.57f, 0f,
            width * 0.65f, 0f
        )
        lineTo(width, 0f)
        lineTo(width, height)
        close()
    }
}