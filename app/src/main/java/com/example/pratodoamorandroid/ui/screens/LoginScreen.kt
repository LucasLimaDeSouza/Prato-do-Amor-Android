package com.example.pratodoamorandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.components.ButtonComponent
import com.example.pratodoamorandroid.ui.components.ImageComponent
import com.example.pratodoamorandroid.ui.components.TextComponent
import com.example.pratodoamorandroid.ui.components.TextFieldComponent
import com.example.pratodoamorandroid.ui.navigation.Screen
import com.example.pratodoamorandroid.ui.theme.BackgroundColor
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.RedTitle
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.utils.TypeInputEnum
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = BackgroundColor,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(294.dp, 208.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    ImageComponent()
                    Spacer(modifier = Modifier.height(35.3.dp))
                    TextComponent(navController, letterSpacing = (-1.5).sp)
                    TextComponent(
                        isTitleOrNo = false,
                        text = "Plataforma de Gestão de Cuidados",
                        fontSize = 14,
                        letterSpacing = 0.sp,
                        fontWeight = FontWeight.Medium,
                        color = GreyText,

                    )

                }
            }
            Box(
                modifier = Modifier
                    .size(294.dp, 332.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start
                ) {
                    TextComponent(
                        isTitleOrNo = false,
                        text = "E-mail",
                        fontSize = 14,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.sp,
                        color = BlackText,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldComponent(
                        typeInput = TypeInputEnum.EMAIL,
                        onValueChange = {},
                        textLabel = TypeTextLabelEnum.EMAIL,
                        value = ""
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        TextComponent(
                            isTitleOrNo = false,
                            text = "Senha",
                            fontSize = 14,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.sp,
                            color = BlackText,
                            navController = navController
                        )
                        TextComponent(
                            isTitleOrNo = true,
                            text = "Esqueceu a senha?",
                            fontSize = 14,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.sp,
                            color = RedTitle,
                            isClickable = true,
                            nextPage = Screen.RecoverPasswordScreen.route,
                            navController = navController
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldComponent(
                        typeInput = TypeInputEnum.PASSWORD,
                        onValueChange = {},
                        textLabel = TypeTextLabelEnum.PASSWORD,
                        value = ""
                    )
                    Spacer(modifier = Modifier.height(48.dp))
                    ButtonComponent(
                        onClick = {},
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                TextComponent(
                                    text = "Entrar",
                                    color = TextColor,
                                    fontSize = 18,
                                    letterSpacing = 0.sp,
                                    navController = navController
                                )
                                Spacer(modifier = Modifier.width(8.dp))

                                Image(
                                    modifier = Modifier
                                        .size(18.dp),
                                    contentDescription = "",
                                    painter = painterResource(R.drawable.icon_enter)
                                )
                            }
                        },
                        navController = navController
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.bottom_logo), contentDescription = "")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        navController = NavHostController(LocalContext.current)
    )
}