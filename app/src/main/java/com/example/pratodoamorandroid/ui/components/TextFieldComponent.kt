package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.theme.ColorLabel
import com.example.pratodoamorandroid.ui.utils.TypeInputEnum
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum

@Composable
fun TextFieldComponent(
    typeInput: TypeInputEnum = TypeInputEnum.PASSWORD,
    textLabel: TypeTextLabelEnum = TypeTextLabelEnum.PASSWORD,
    onValueChange: (String) -> Unit,
    value: String = "",
//    painterForImage: Painter = painterResource(R.drawable.icon_1),
) {
    var passwordVisible by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxWidth()
    ) {


        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                when (textLabel) {
                    TypeTextLabelEnum.EMAIL -> {
                        Text(text = TypeTextLabelEnum.EMAIL.id, color = ColorLabel)
                    }

                    TypeTextLabelEnum.PASSWORD -> {
                        Text(text = TypeTextLabelEnum.PASSWORD.id, color = ColorLabel)
                    }

                    TypeTextLabelEnum.STRING -> {
                        Text(text = TypeTextLabelEnum.STRING.id, color = ColorLabel)
                    }
                }
            },
            leadingIcon = {
                when (typeInput) {
                    TypeInputEnum.PASSWORD -> Icon(Icons.Filled.Lock, null)
                    TypeInputEnum.EMAIL -> Icon(Icons.Filled.Email, null)
                    TypeInputEnum.STRING -> Icon(Icons.Filled.Abc, null)
                }
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            visualTransformation = when (typeInput) {
                TypeInputEnum.PASSWORD -> if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None
                else -> VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = when (typeInput) {
                    TypeInputEnum.STRING -> KeyboardType.Text
                    TypeInputEnum.EMAIL -> KeyboardType.Email
                    TypeInputEnum.PASSWORD -> KeyboardType.Password
                }
            ),
            trailingIcon = {
                if (typeInput == TypeInputEnum.PASSWORD) {
                    val icon =
                        if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(icon, contentDescription = null)
                    }
                }
            },
            singleLine = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldComponentPreview() {
    TextFieldComponent(
        onValueChange = {},
        value = "",
    )
}