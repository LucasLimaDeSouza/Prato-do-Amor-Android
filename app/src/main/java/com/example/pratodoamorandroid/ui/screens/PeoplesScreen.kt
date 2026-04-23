package com.example.pratodoamorandroid.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.navigation.compose.rememberNavController
import com.example.pratodoamorandroid.ui.components.ImageComponent
import com.example.pratodoamorandroid.ui.components.TextComponent
import com.example.pratodoamorandroid.R
import com.example.pratodoamorandroid.ui.components.DataCardComponent
import com.example.pratodoamorandroid.ui.components.PersonCardComponent
import com.example.pratodoamorandroid.ui.components.TextFieldComponent
import com.example.pratodoamorandroid.ui.navigation.Screen
import com.example.pratodoamorandroid.ui.theme.BackgroundColor
import com.example.pratodoamorandroid.ui.theme.GreyCard
import com.example.pratodoamorandroid.ui.theme.GreyText
import com.example.pratodoamorandroid.ui.theme.RedHeart
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.utils.Destination
import com.example.pratodoamorandroid.ui.utils.TextLabelEnum
import com.example.pratodoamorandroid.ui.utils.TextTitleEnum


@Composable
fun PeoplesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val startDestination = Destination.PEOPLES
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }
    Scaffold(
        modifier = modifier,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundColor)
                    .padding(18.dp, 40.dp, 18.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextComponent(letterSpacing = (-0.5).sp, fontSize = 20)
                ImageComponent(
                    painterForImage = painterResource(R.drawable.screen_config_button),
                    size = 40,
                    onClick = {
                        navController.navigate(route = Screen.ADMScreen.route)
                    }
                )
            }
        },
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = BackgroundColor
            ) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = RedHeart,
                            selectedIconColor = TextColor,
                        ),
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = { Text(destination.label) }
                    )
                }
            }
        },
        floatingActionButton = {
            ImageComponent(painterForImage = painterResource(R.drawable.add_people_button), size = 104)
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            color = BackgroundColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {

                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .fillMaxWidth()
                                .background(GreyCard)
                        )

                        TextComponent(text = "Pessoas Atendidas")
                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                                .fillMaxWidth()
                        )
                        TextComponent(
                            isTitleOrNo = false,
                            text = "Gestão e acompanhamento da comunidade\n" +
                                    "assistida",
                            fontSize = 16,
                            letterSpacing = 0.sp,
                            fontWeight = FontWeight.Medium,
                            color = GreyText,
                            alignCenter = false
                        )
                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                                .fillMaxWidth()
                        )
                        TextFieldComponent(
                            value = "",
                            onValueChange = {},
                            simpleTextLabel = TextLabelEnum.SEARCH,
                            isSearch = true
                        )

                        Spacer(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth()
                        )

                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(10) {
                                PersonCardComponent(name = "Maria do Carmo da Silva Nogueira",navController = navController)
                                Spacer(
                                    modifier = Modifier
                                        .height(12.dp)
                                        .weight(1f)
                                )
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
private fun PeoplesScreenPreview() {
    PeoplesScreen(navController = NavHostController(LocalContext.current))
}