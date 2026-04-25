package com.example.pratodoamorandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.pratodoamorandroid.ui.theme.BackgroundCard
import com.example.pratodoamorandroid.ui.theme.BackgroundColor
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.CardColor
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.utils.TypeInputEnum
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeoplePerfilScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
//                        content = TENTAR TORNAR TUDO CLICAVEL
                    ) {
                        ImageComponent(
                            painterForImage = painterResource(R.drawable.baseline_arrow_back_24),
                            size = 20

                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        TextComponent(
                            text = "Voltar",
                            fontSize = 20,
                            navController = navController,
                            isClickable = true,
                            nextPage = Screen.PeoplesScreen.route
                        )
                    }
                },
                expandedHeight = 48.dp,
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = BackgroundColor,
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp,0.dp,24.dp,44.dp)
            ) {
                item {


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .background(
                                color = BackgroundCard,
                                shape = RoundedCornerShape(12.dp)
                            ),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            ImageComponent(
                                painterForImage = painterResource(R.drawable.camera_button),
                                size = 160
                            )

                            TextComponent(
                                isTitleOrNo = false,
                                text = "Tire uma foto",
                                fontSize = 16,
                                letterSpacing = 0.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = GreyText,
                                alignCenter = false
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    TextComponent(
                        isTitleOrNo = false,
                        text = "Nome Completo (ou apelido)",
                        fontSize = 14,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.sp,
                        color = BlackText,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldComponent(
                        typeInput = TypeInputEnum.STRING,
                        textLabel = TypeTextLabelEnum.IDENTIFICATION,
                        onValueChange = {},
                        value = "",
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextComponent(
                        isTitleOrNo = false,
                        text = "Gênero",
                        fontSize = 14,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.sp,
                        color = BlackText,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ButtonComponent(
                            modifier = Modifier
                                .height(72.dp)
                                .width(110.dp),
                            backgroundColor = CardColor,
                            onClick = {},
                            text = {
                                TextComponent(
                                    fontSize = 14,
                                    text = "Masculino",
                                )
                            }

                        )
                        ButtonComponent(
                            modifier = Modifier
                                .height(72.dp)
                                .width(110.dp),
                            backgroundColor = CardColor,
                            onClick = {},
                            text = {
                                TextComponent(
                                    fontSize = 14,
                                    text = "Feminino",
                                )
                            }

                        )
                        ButtonComponent(
                            modifier = Modifier
                                .height(72.dp)
                                .width(110.dp),
                            backgroundColor = CardColor,
                            onClick = {},
                            text = {
                                TextComponent(
                                    fontSize = 14,
                                    text = "Outro",
                                )
                            }

                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    TextComponent(
                        isTitleOrNo = false,
                        text = "Localização de Permanência",
                        fontSize = 14,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.sp,
                        color = BlackText,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldComponent(
                        typeInput = TypeInputEnum.STRING,
                        textLabel = TypeTextLabelEnum.LOCATION,
                        onValueChange = {},
                        value = "",
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    TextComponent(
                        isTitleOrNo = false,
                        text = "Observações Visuais (Opcional)",
                        fontSize = 14,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.sp,
                        color = BlackText,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldComponent(
                        typeInput = TypeInputEnum.STRING,
                        textLabel = TypeTextLabelEnum.DETAILSOFVISIT,
                        onValueChange = {},
                        value = "",
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    ButtonComponent(
                        onClick = {},
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                TextComponent(
                                    text = "Finalizar Cadastro",
                                    color = TextColor,
                                    fontSize = 18,
                                    letterSpacing = 0.sp,
                                    navController = navController
                                )
                                Spacer(modifier = Modifier.width(8.dp))

                            }
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun PeoplePerfilScreenPreview() {
    PeoplePerfilScreen(
        navController = NavHostController(LocalContext.current)
    )
}