package com.openinapp.presentation.main.links

import android.content.res.ColorStateList
import android.graphics.Color.RED
import android.graphics.Color.toArgb
import android.graphics.drawable.Drawable
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.renderer.XAxisRenderer
import com.github.mikephil.charting.utils.ViewPortHandler
import com.openinapp.R
import com.openinapp.presentation.main.links._components.GreetingView
import com.openinapp.presentation.main.links._components.TopBar
import com.openinapp.ui.theme.Figtree
import kotlin.math.roundToInt

@Composable
fun LinksScreen() {

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    val entries = listOf(
        Entry(0f, 10f),
        Entry(1f, 25f),
        Entry(2f, 30f),
        Entry(3f, 80f),
        Entry(4f, 75f),
        Entry(5f, 100f),
        Entry(6f, 50f),
        Entry(7f, 25f),
        Entry(8f, 100f),
        Entry(9f, 80f),
    )
    val dataSet = LineDataSet(entries, null)
    dataSet.apply {
        this.color = MaterialTheme.colorScheme.primary.toArgb()
        this.lineWidth = 6f
        this.highLightColor = MaterialTheme.colorScheme.primary.toArgb()
        this.highlightLineWidth = 1f
        this.setCircleColors(MaterialTheme.colorScheme.primary.toArgb())
        this.setDrawCircleHole(false)
        this.circleRadius = 3f
        this.setDrawFilled(true)
        this.fillDrawable = context.getDrawable(R.drawable.chart_background)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_secondary))
            .verticalScroll(scrollState)
    ) {

        TopBar()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(1000.dp)
                .offset(y = (-24).dp)
                .background(
                    color = colorResource(R.color.background_secondary),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
        ) {

            GreetingView()

            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .background(
                        colorResource(R.color.background_primary),
                        RoundedCornerShape(10.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Overview",
                        fontFamily = FontFamily.Figtree,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = colorResource(R.color.text_secondary)
                    )
                    Row(
                        modifier = Modifier
                            .border(
                                width = 1.5.dp,
                                color = colorResource(R.color.light_gray),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "22 Aug - 23 Sept",
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Figtree,
                            lineHeight = 12.sp
                        )
                        Icon(
                            modifier = Modifier.size(15.dp).aspectRatio(1f),
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null
                        )
                    }
                }
                AndroidView(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 17.dp)
                        .fillMaxWidth()
                        .height(160.dp),
                    factory = { context ->
                        LineChart(context).apply {
                            this.legend.isEnabled = false
                            this.data = LineData(dataSet).apply {
                                this.setDrawValues(false)
                            }
                            this.description = null
                            this.xAxis.apply {
                                this.valueFormatter = object : ValueFormatter() {
                                    private val xAxisLabels = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
                                    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                                        return xAxisLabels.getOrNull(value.roundToInt()) ?: value.toString()
                                    }
                                }

                                this.position = XAxis.XAxisPosition.BOTTOM
                                this.labelCount = 8
                                this.textSize = 10f
                                this.textColor = Color(0XFF999CA0).toArgb()
                                this.gridColor = Color(0XFFF2F2F2).toArgb()
                                this.gridLineWidth = 1f
                                this.setAvoidFirstLastClipping(true)
                            }
                            this.axisLeft.apply {
                                this.axisMinimum = 0f
                                this.textSize = 10f
                                this.textColor = Color(0XFF999CA0).toArgb()
                                this.gridColor = Color(0XFFF2F2F2).toArgb()
                                this.gridLineWidth = 1f
                                this.setDrawZeroLine(false)
                            }
                            this.axisRight.isEnabled = false
                            this.setDrawGridBackground(false)
                            this.setDrawMarkers(false)
                        }
                    },
                    update = {
                    }
                )
            }

        }

    }
}