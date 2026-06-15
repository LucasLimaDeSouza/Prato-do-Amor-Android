package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pratodoamorandroid.ui.theme.BlackText

@Composable
fun PizzaGraphComponent(
    data: List<Float>,
    color: List<Color> = listOf(Color.Red, Color.Blue, Color.Green)
) {
    val total = data.sum()
    var startAngle = -90f

    Box(
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        ) {


            val size = size.minDimension
            val radius = size.div(2)
            val center = Offset(size.div(2), size.div(2))

            data.forEachIndexed { index, value ->
                val sweepAngle = (value.div(total)) * 360f
                drawArc(
                    color = color.get(index),
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = true,
                    topLeft = Offset(center.x - radius, center.y - radius),
                    size = Size(width = radius.times(2), height = radius.times(2)),
                )

                startAngle += sweepAngle
            }
            val innerRadius = radius.times(0.6f)

            drawCircle(
                color = Color.White,
                radius = innerRadius,
                center = center
            )


        }
        Column(
            modifier = Modifier
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TextComponent(
                text = "Total",
                fontSize = 18,
                color = BlackText
            )
            TextComponent(
                text = "Atendidos",
                fontSize = 12,
                color = BlackText,
                fontWeight = FontWeight.Light,
                letterSpacing = 2.sp
            )
        }
    }
}

//@Preview
//@Composable
//private fun PizzaGraphComponentPreview() {
//    PizzaGraphComponent(
//
//    )
//
//}