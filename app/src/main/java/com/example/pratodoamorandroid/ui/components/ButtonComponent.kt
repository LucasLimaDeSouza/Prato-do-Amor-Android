package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.ColorText
import com.example.pratodoamorandroid.ui.theme.RedHeart

@Composable
fun ButtonComponent(
    onClick: () -> Unit,
    text: @Composable () -> Unit,
    painterForImage: Painter = painterResource(R.drawable.icon_enter)
) {

    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            isPressed = interaction is PressInteraction.Press
        }
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(294.dp)
            .height(56.dp),
//        enabled = ,
        shape = RoundedCornerShape(26.dp),
        colors = ButtonDefaults.buttonColors(
//            containerColor = if (isPressed) Color.Red else Color.Blue
            containerColor = RedHeart
        ),
//        elevation = ,
//        border = ,
        contentPadding = PaddingValues(),
        interactionSource = interactionSource
    ) {
        text()
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonComponentPreview() {
    ButtonComponent(
        onClick = {},
        text = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextComponent(text = "Entrar", color = ColorText, fontSize = 18.sp, letterSpacing = 0.sp)
                Image(modifier = Modifier
                    .size(18.dp),contentDescription = "", painter = painterResource(R.drawable.icon_enter))
            }
        }
    )
}