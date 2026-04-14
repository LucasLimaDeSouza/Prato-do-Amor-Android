package com.example.pratodoamorandroid.ui.screens

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
import com.example.pratodoamorandroid.ui.theme.BackgroundColor
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.GreyCard
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.RedTitle
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.utils.TypeInputEnum
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ADMScreen(
    navHostController: NavHostController
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
                        Spacer(modifier = Modifier.width(26.dp))
                        TextComponent(
                            text = "Voltar",
                            fontSize = 20,
                            navController = navHostController,
                            isClickable = true,
                            nextPage = Screen.LoginScreen.route
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(248.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        ImageComponent(
                            painterForImage = painterResource(R.drawable.baseline_admin_panel_settings_24),
                            size = 124
                        )
                        TextComponent(
                            text = "Administração",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 24,
                            isTitleOrNo = true,
                            color = BlackText,
                            navController = navHostController
                        )
                        TextComponent(
                            text = "Configurações",
                            fontSize = 16,
                            fontWeight = FontWeight.Medium,
                            isTitleOrNo = false,
                            color = GreyText,
                            navController = navHostController
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextComponent(
                            text = "PRATO DO AMOR ANDROID v1.0.0",
                            fontSize = 12,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 2.4.sp,
                            isTitleOrNo = false,
                            color = GreyText,
                            navController = navHostController
                        )
                    }

                }
//                Spacer(modifier = Modifier.height(48.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        ImageComponent(
                            painterForImage = painterResource(R.drawable.secutiy),
                            size = 20
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        TextComponent(
                            text = "Segurança",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18,
                            isTitleOrNo = true,
                            color = BlackText,
                            navController = navHostController
                        )
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 54.dp),
                        color = GreyCard,
                        shape = RoundedCornerShape(12.dp)

                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(24.dp),
                                ) {
                                    TextComponent(
                                        text = "Alterar Senha",
                                        fontSize = 20,
                                        fontWeight = FontWeight.Bold,
                                        isTitleOrNo = true,
                                        color = RedTitle,
                                        navController = navHostController
                                    )
                                    Spacer(modifier = Modifier.height(7.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "Mantenha sua conta de administrador\n" +
                                                "segura atualizando sua senha\n" +
                                                "regularmente. Recomendamos uma\n" +
                                                "combinação forte de caracteres.",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp,
                                        color = GreyText,
                                        navController = navHostController,
                                        alignCenter = false
                                    )
                                    Spacer(modifier = Modifier.height(32.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "Senha Atual",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,
                                        navController = navHostController
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextFieldComponent(
                                        typeInput = TypeInputEnum.PASSWORD,
                                        onValueChange = {},
                                        textLabel = TypeTextLabelEnum.PASSWORD,
                                        value = ""
                                    )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "Nova Senha",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,
                                        navController = navHostController
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextFieldComponent(
                                        typeInput = TypeInputEnum.PASSWORD,
                                        onValueChange = {},
                                        textLabel = TypeTextLabelEnum.PASSWORD,
                                        value = ""
                                    )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "Confirmar Nova Senha",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,
                                        navController = navHostController
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextFieldComponent(
                                        typeInput = TypeInputEnum.PASSWORD,
                                        onValueChange = {},
                                        textLabel = TypeTextLabelEnum.PASSWORD,
                                        value = ""
                                    )
                                    Spacer(modifier = Modifier.height(40.dp))
                                    ButtonComponent(
                                        onClick = {},
                                        text = {
                                            TextComponent(
                                                text = "Salvar Nova Senha",
                                                color = TextColor,
                                                fontSize = 18,
                                                letterSpacing = 0.sp,
                                                navController = navHostController
                                            )
                                        },
                                        navController = navHostController
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun ADMScreenPreview() {
    ADMScreen(
        navHostController = NavHostController(LocalContext.current)
    )

}