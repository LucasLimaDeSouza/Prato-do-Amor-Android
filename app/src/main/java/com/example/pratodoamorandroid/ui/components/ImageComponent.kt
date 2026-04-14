package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pratodoamorandroid.R

@Composable
fun ImageComponent(
    painterForImage: Painter = painterResource(R.drawable.heart),
    size: Int = 64
) {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(26.dp)),

    ) {
        Image(
            modifier = Modifier.size(size.dp),
            contentDescription = "photo_or_image",
            painter = painterForImage
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ImageComponentPreview() {
    ImageComponent()
}