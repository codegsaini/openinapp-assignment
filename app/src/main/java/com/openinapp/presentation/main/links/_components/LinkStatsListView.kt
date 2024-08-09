package com.openinapp.presentation.main.links._components

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.openinapp.R
import com.openinapp.domain.model.Link
import com.openinapp.ui.theme.Figtree
import dashedBorder
import io.ktor.utils.io.CancellationException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun LinkStatsListView(
    modifier: Modifier = Modifier,
    items: List<Link>,
    context: Context,
    clipboardManager: ClipboardManager
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items.forEach { link ->
            LinkStatItem(link, context) {
                clipboardManager.setText(AnnotatedString(link.webLink))
            }
        }
    }
}

@Composable
private fun LinkStatItem(link: Link, context: Context, onCopy: () -> Unit) {
    val request = ImageRequest.Builder(context)
        .data(link.originalImage)
        .diskCacheKey(link.originalImage)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCacheKey(link.originalImage)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .build()

    val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

    val formatedDate =  try {
        val date = LocalDate.parse(link.createdAt, dateFormat)
        val month = date.month.toString().lowercase()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
        "${date.dayOfMonth} ${month.substring(0, 3)} ${date.year}"
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        link.createdAt
    }

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
            AsyncImage(
                model = request,
                modifier = Modifier
                    .size(48.dp)
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = colorResource(R.color.background_secondary),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                contentDescription = null,
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
                    color = colorResource(R.color.text_primary),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = formatedDate,
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
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(R.color.primary)
            )
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { onCopy() }
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