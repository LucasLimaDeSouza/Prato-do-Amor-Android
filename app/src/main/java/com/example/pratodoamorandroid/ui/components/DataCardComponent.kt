package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.CardColor
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.RedHeart
import com.example.pratodoamorandroid.ui.utils.TypeTextTitleEnum


@Composable
fun DataCardComponent(
    modifier: Modifier = Modifier,
    title: TypeTextTitleEnum = TypeTextTitleEnum.TOTAL,
    data: String = "1,284",
    isTotal: Boolean = true
) {

    Card(
        modifier = modifier
            .height(106.dp)
            .width(171.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            TextComponent(
                isTitleOrNo = false,
                text = title.id,
                fontSize = 12,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.2.sp,
                color = GreyText
            )

            TextComponent(
                isTitleOrNo = false,
                text = data,
                fontSize = 30,
                fontWeight = FontWeight.SemiBold,
                color = if (isTotal) RedHeart else BlackText
            )
        }
    }


}

@Preview
@Composable
private fun DataCardComponentPreview() {
    DataCardComponent()
}