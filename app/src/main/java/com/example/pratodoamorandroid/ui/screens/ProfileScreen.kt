package com.example.pratodoamorandroid.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.pratodoamorandroid.domain.model.HelpModel
import com.example.pratodoamorandroid.domain.repository.mock.MockReppository
import com.example.pratodoamorandroid.ui.components.ButtonComponent
import com.example.pratodoamorandroid.ui.components.HelpOptionsComponent
import com.example.pratodoamorandroid.ui.components.ImageComponent
import com.example.pratodoamorandroid.ui.components.TextComponent
import com.example.pratodoamorandroid.ui.components.dialogs.EditProfileDialog
import com.example.pratodoamorandroid.ui.navigation.Screen
import com.example.pratodoamorandroid.ui.theme.BackgroundCard
import com.example.pratodoamorandroid.ui.theme.BackgroundColor
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.CardColor
import com.example.pratodoamorandroid.ui.theme.ColorLabel
import com.example.pratodoamorandroid.ui.theme.RedTitle
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.utils.TypePainterIdEnum
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    repository: MockReppository = MockReppository(),
    navController: NavHostController = NavHostController(LocalContext.current)
) {
    val people = repository.getPeople().let { it[0] }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                ),
                title = {
                    ImageComponent(
                        painterForImage = painterResource(R.drawable.baseline_arrow_back_24),
                        size = 45,
                        onClick = {
                            navController.navigate(route = Screen.PeoplesScreen.route)
                        }
                    )

                },
                expandedHeight = 18.dp,
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
                    .padding(24.dp, 15.dp, 24.dp, 44.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        ImageComponent(
                            painterForImage = painterResource(R.drawable.ic_launcher_background),
                            size = 240
                        )
                    }


                    Spacer(modifier = Modifier.height(32.dp))
                    TextComponent(
                        isTitleOrNo = true,
                        text = people.name,
                        fontSize = 26,
                        fontWeight = FontWeight.Bold,
                        alignCenter = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(433.dp)
                            .clickable(
                                onClick = {
                                    showDialog = !showDialog
                                }
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = CardColor
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                        ) {
                            TextComponent(
                                text = "INFORMAÇÕES PESSOAIS",
                                fontSize = 20,
                                fontWeight = FontWeight.Bold,
                                isTitleOrNo = true,
                                color = RedTitle,
                            )

                            Spacer(modifier = Modifier.height(32.dp))
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize(),
                            ) {
                                item {

                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "CPF",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = ColorLabel,

                                        )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = people.cpf,
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,

                                        )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "SEXO",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = ColorLabel,

                                        )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = people.sex,
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,

                                        )

                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "TELEFONE CONTATO",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = ColorLabel,

                                        )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = people.tell,
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,

                                        )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "LOCALIZAÇÃO",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = ColorLabel,

                                        )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = people.location,
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,

                                        )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "NECESSIDADES ESPECIAIS",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = ColorLabel,

                                        )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = people.specialNeeds,
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,

                                        )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = "ALERGIAS",
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = ColorLabel,

                                        )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextComponent(
                                        isTitleOrNo = false,
                                        text = people.allergies,
                                        fontSize = 14,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.sp,
                                        color = BlackText,

                                        )
                                    Spacer(modifier = Modifier.height(24.dp))
                                }
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(433.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = BackgroundCard
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(24.dp)
                                .fillMaxSize(),
                        ) {
                            TextComponent(
                                text = "HISTÓRICO DE AJUDAS",
                                fontSize = 20,
                                fontWeight = FontWeight.Bold,
                                isTitleOrNo = true,
                                color = RedTitle,
                            )

                            Spacer(modifier = Modifier.height(32.dp))

                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(433.dp)

                            ) {

                                item {
                                    repository.getHelpHistory().forEach { help ->

                                        val painterIdValue = when (help.help) {
                                            TypePainterIdEnum.FOOD.id -> R.drawable.option_food
                                            TypePainterIdEnum.BATH.id -> R.drawable.option_bath
                                            TypePainterIdEnum.MED.id -> R.drawable.option_med
                                            else -> R.drawable.option_food

                                        }

                                        HelpOptionsComponent(
                                            painterId = painterIdValue,
                                            help = help.help,
                                            description = help.description,
                                            date = help.date
                                        )

                                    }
                                }
                            }
                        }
                    }
                    if (showDialog) {
                        EditProfileDialog(
                            onDismiss = { showDialog = false },
                            onSave = { phone, needs, allergies ->
                                // Lógica para salvar
                                showDialog = false
                            }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable()
private fun ProfileScreenPreview() {
//    HelpOptionsComponent()
    ProfileScreen()
}