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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pratodoamorandroid.ui.theme.BackgroundCard
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.CardColor
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.RedCard

@Composable
fun CardPersonComponent(
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .height(228.dp)
            .fillMaxWidth()
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        )
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
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageComponent(size = 126)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
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
                                text = "Maria Eduarda",
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
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.End
                        ) {

                            Card(
                                modifier = Modifier
                                    .width(196.dp)
                                    .height(140.dp),
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

@Preview(showBackground = true)
@Composable
private fun CardPersonComponentPreview() {
    CardPersonComponent(
        navHostController = NavHostController(context = LocalContext.current)
    )
}