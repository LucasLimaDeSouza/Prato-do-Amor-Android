package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.theme.RedHeart
import com.example.pratodoamorandroid.ui.theme.RedTitle

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: @Composable () -> Unit,
    backgroundColor: Color = RedTitle,
    navController: NavHostController = NavHostController(LocalContext.current),
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
        modifier = modifier
//            .padding(5.dp)
            .fillMaxWidth()
            .height(56.dp),
//        enabled = ,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) Color.Red else backgroundColor,
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
        navController = NavHostController(LocalContext.current),
        text = {
            Row(
                modifier = Modifier
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextComponent(
                    text = "Entrar",
                    color = TextColor,
                    fontSize = 18,
                    letterSpacing = 0.sp,

                    )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    modifier = Modifier
                        .size(18.dp),
                    contentDescription = "",
                    painter = painterResource(R.drawable.icon_enter)
                )
            }
        }
    )
}