package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.ColorLabel
import com.example.pratodoamorandroid.ui.utils.TypeInputEnum
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    typeInput: TypeInputEnum = TypeInputEnum.STRING,
    textLabel: TypeTextLabelEnum = TypeTextLabelEnum.STRING,
    onValueChange: (String) -> Unit,
    value: String = "",
    isSearch: Boolean = false,
    singleLine: Boolean = true,
    color: Color = BlackText
) {
    var passwordVisible by remember { mutableStateOf(false) }



        OutlinedTextField(
            maxLines = if (singleLine) 1 else 5,
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = textLabel.id,
                    color = ColorLabel,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            leadingIcon = if (isSearch) {
                { Icon(Icons.Filled.Search, contentDescription = null) }
            } else {
                when (typeInput) {
                    TypeInputEnum.PASSWORD -> {
                        { Icon(Icons.Filled.Lock, null) }
                    }

                    TypeInputEnum.EMAIL -> {
                        { Icon(Icons.Filled.Email, null) }
                    }

                    TypeInputEnum.STRING -> {
                        when (textLabel) {
                            TypeTextLabelEnum.SEARCH -> {
                                { Icon(Icons.Filled.Search, null) }
                            }

                            TypeTextLabelEnum.LOCATION -> {
                                { Icon(Icons.Filled.LocationOn, null) }
                            }

                            else -> null
                        }

                    }
//                    TypeInputEnum.LOCATION -> { { Icon(Icons.Filled.LocationOn, null) } }

                }
            },
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
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
            singleLine = singleLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = color,
                unfocusedBorderColor = color,
            )
        )

}

@Preview(showBackground = true)
@Composable
private fun TextFieldComponentPreview() {
    TextFieldComponent(
        onValueChange = {},
        value = "",
    )
}