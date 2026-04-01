package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.ColorLabel

@Composable
fun TextFieldComponent(
    isPassword: Boolean = true,
    modifier: Modifier = Modifier,
    painterForImage: Painter = painterResource(R.drawable.icon_1),
    textLabel: String = "nome@exemplo.com"
) {
    var texto by remember { mutableStateOf("") }
    var passwordVisible  by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        placeholder = { Text(textLabel, color = ColorLabel) },
        leadingIcon = {
            Image(
                contentDescription = "photo_or_image",
                painter = painterForImage
            )
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(16.dp),
        visualTransformation = when {
            isPassword && !passwordVisible -> PasswordVisualTransformation()
            else -> VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Email
        ),
        trailingIcon = if (isPassword) {
            {
                val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(icon, contentDescription = null)
                }
            }
        } else null,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldComponentPreview() {
    TextFieldComponent()
}