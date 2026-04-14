package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.RedHeart

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextComponent(
    navController: NavHostController,
    isTitleOrNo: Boolean = true,
    text: String = "Prato do Amor",
    fontSize: Int = 30,
    fontWeight: FontWeight = FontWeight.ExtraBold,
    letterSpacing: TextUnit = 0.sp,
    color: Color = RedHeart,
    isClickable: Boolean = false,
    nextPage: String = "",
    alignCenter: Boolean = true
) {
    val manropeFamily = FontFamily(
        Font(
            resId = R.font.manrope_variable,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(400)
            )
        )
    )

    val interFamily = FontFamily(
        Font(
            resId = R.font.manrope_variable,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(400)
            )
        )
    )

    Text(
        fontFamily =  if(isTitleOrNo == true) manropeFamily else interFamily,
        text = text,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        color = color,
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Start,
        modifier = Modifier
            .clickable(
                enabled = isClickable,
                onClick = {
                    if (isClickable) {
                        navController.navigate(nextPage)
                    }
                }
            )
    )
}

