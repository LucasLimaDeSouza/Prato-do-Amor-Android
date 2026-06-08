package com.example.pratodoamorandroid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pratodoamorandroid.ui.navigation.Screen
import com.example.pratodoamorandroid.ui.theme.BackgroundCard
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.CardColor
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.RedCard
import com.example.pratodoamorandroid.ui.theme.RedHeart

@Composable
fun PersonCardComponent(
    navController: NavHostController,
    name: String = "Maria Eduarda",
    photo: @Composable () -> Unit = {
        ImageComponent(size = 96)
    },
    route: String = ""

) {
    Card(
        modifier = Modifier
            .height(208.dp)
            .shadow(
                elevation = 8.dp, // Intensidade da sombra
                shape = RoundedCornerShape(12.dp), // Deve ser igual ao shape do botão
                spotColor = BlackText, // Cor da sombra projetada
                ambientColor = RedHeart // Cor da sombra ao redor
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        onClick = {
            navController.navigate(route = route)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()


        ) {
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxHeight(),

                ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    photo()
                }
            }
            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    LazyRow {
                        item {

                            TextComponent(
                                text = name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20,
                                isTitleOrNo = true,
                                color = BlackText,
                                alignCenter = true,
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = RedCard
                        ),
                        onClick = {
                            navController.navigate(route = route)
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.End
                        ) {

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(140.dp)
                                    .padding(4.dp, 0.dp, 0.dp, 0.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = BackgroundCard
                                ),
                                shape = RoundedCornerShape(2.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(12.dp),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                ) {
                                    TextComponent(
                                        text = "Última Ajuda",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15,
                                        isTitleOrNo = true,
                                        color = GreyText,
                                        alignCenter = false,
                                    )

                                    /*
                                    * IMPLEMENTAR UMA LISTA DE AJUDAS APLICADAS
                                    * E FINALIZAR COM "e mais..." AO LADO DA ULTIMA
                                    *  QUANDO PASSAR DE 3 (TRÊS).
                                    * */

                                    TextComponent(
                                        text = "Cesta Básica &\n" +
                                                "Medicamentos de uso\n" +
                                                "contínuo",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14,
                                        isTitleOrNo = false,
                                        color = BlackText,
                                        alignCenter = false,

                                        )
                                    TextComponent(
                                        text = "Realizada em 14 Out, 2023",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10,
                                        letterSpacing = 1.sp,
                                        isTitleOrNo = false,
                                        color = GreyText,
                                        alignCenter = true,
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

@Preview(backgroundColor = 0xFF570000, showBackground = true)
@Composable
private fun PersonCardComponentPreview() {
    PersonCardComponent(
        navController = NavHostController(context = LocalContext.current)
    )
}