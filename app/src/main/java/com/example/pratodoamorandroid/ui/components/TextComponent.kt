package com.example.pratodoamorandroid.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.RedHeart

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextComponent(
    text: String = "Prato do Amor",
    fontSize: TextUnit = 36.sp,
    fontWeight: FontWeight = FontWeight.ExtraBold,
    letterSpacing: TextUnit = (-1.5).sp,
    color: Color = RedHeart
) {
    val ManropeFamily = FontFamily(
        Font(
            resId = R.font.manrope_variable,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(400)
            )
        )
    )

    Text(
        fontFamily = ManropeFamily,
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
private fun TextComponentPreview() {
    TextComponent()
}

