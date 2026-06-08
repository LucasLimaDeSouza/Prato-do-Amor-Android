package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.ColorLabel

@Preview
@Composable
private fun HelpOptionsComponentPreview() {
    HelpOptionsComponent()
}

@Composable
fun HelpOptionsComponent(
    painterId: Int = R.drawable.option_food,
    help: String = "Entrega de Alimentos",
    description: String = "Cesta básica mensal e kit higiene entregues pessoalmente.",
    date: String = "00/00/00"
) {


    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
//            .height(137.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ImageComponent(
                painterForImage = painterResource(painterId),
                size = 48
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextComponent(
                modifier = Modifier.fillMaxWidth(),
                text = help,
                fontSize = 16,
                color = BlackText,
                isTitleOrNo = false,
                alignCenter = false,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextComponent(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                fontSize = 14,
                color = ColorLabel,
                isTitleOrNo = false,
                fontWeight = FontWeight.SemiBold,
                alignCenter = false
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextComponent(
                text = date,
                fontSize = 12,
                color = ColorLabel,
                isTitleOrNo = false,
                fontWeight = FontWeight.SemiBold,
                alignCenter = false
            )
        }
    }
}