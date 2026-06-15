package com.example.pratodoamorandroid.ui.screens

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pratodoamorandroid.domain.model.PeopleModel
import com.example.pratodoamorandroid.domain.repository.mock.MockReppository
import com.example.pratodoamorandroid.ui.components.HelpOptionsComponent
import com.example.pratodoamorandroid.ui.components.PersonCardComponent
import com.example.pratodoamorandroid.ui.components.PizzaGraphComponent
import com.example.pratodoamorandroid.ui.components.TextComponent
import com.example.pratodoamorandroid.ui.theme.BackgroundCard
import com.example.pratodoamorandroid.ui.theme.BackgroundColor
import com.example.pratodoamorandroid.ui.theme.BlackText
import com.example.pratodoamorandroid.ui.theme.Pink40
import com.example.pratodoamorandroid.ui.theme.RedHeart
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.theme.YellowSexO
import com.example.pratodoamorandroid.ui.utils.Destination
import com.example.pratodoamorandroid.ui.utils.TypeSexEnum


@Composable
fun ReportsScreen(
    reppository: MockReppository = MockReppository(),
    navController: NavHostController = NavHostController(LocalContext.current)
) {

    val startDestination = Destination.PEOPLES
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal + 1) }

    val peoples = reppository.getPeople()
    val total = remember(peoples) { peoples.size.toFloat() }
    val male = remember { mutableStateListOf<PeopleModel>() }
    val female = remember { mutableStateListOf<PeopleModel>() }
    val other = remember { mutableStateListOf<PeopleModel>() }

    val malePercentage = (male.size.toFloat() / total) * 100
    val femalePercentage = (female.size.toFloat() / total) * 100
    val otherPercentage = (other.size.toFloat() / total) * 100

    LaunchedEffect(peoples) {
        peoples.forEach { people ->
            when (people.sex) {
                TypeSexEnum.M.id -> male.add(people)
                TypeSexEnum.F.id -> female.add(people)
                TypeSexEnum.O.id -> other.add(people)
            }
        }
    }

    Scaffold(
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
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .fillMaxSize(),
            color = BackgroundCard
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .width(342.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(BackgroundCard),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        PizzaGraphComponent(
                            data = listOf(
                                male.size.toFloat(),
                                female.size.toFloat(),
                                other.size.toFloat()
                            ),
                            color = listOf(RedHeart, Pink40, YellowSexO)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Row(
                                modifier = Modifier.width(110.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(RedHeart)
                                )
                                TextComponent(
                                    text = "Masculino",
                                    fontSize = 16,
                                    color = BlackText
                                )
                            }
                            Row(
                                modifier = Modifier.width(100.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextComponent(
                                    text = "${String.format("%.1f", malePercentage)}%",
                                    fontSize = 16,
                                    color = BlackText
                                )
                                TextComponent(
                                    text = "(${
                                        if (female.size > 999) "999>" else female.size
                                    })",
                                    fontSize = if (female.size > 100) 14 else 16,
                                    color = BlackText
                                )

                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Row(
                                modifier = Modifier.width(110.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Pink40)
                                )
                                TextComponent(
                                    text = "Feminino",
                                    fontSize = 16,
                                    color = BlackText
                                )
                            }
                            Row(
                                modifier = Modifier.width(100.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextComponent(
                                    text = "${String.format("%.1f", femalePercentage)}%",
                                    fontSize = 16,
                                    color = BlackText
                                )
                                TextComponent(
                                    text = "(${
                                        if (female.size > 999) "999>" else female.size
                                    })",
                                    fontSize = if (female.size > 100) 14 else 16,
                                    color = BlackText
                                )

                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Row(
                                modifier = Modifier.width(110.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(YellowSexO)
                                )
                                TextComponent(
                                    text = "Outro",
                                    fontSize = 16,
                                    color = BlackText
                                )
                            }
                            Row(
                                modifier = Modifier.width(100.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextComponent(
                                    text = "${String.format("%.1f", otherPercentage)}%",
                                    fontSize = 16,
                                    color = BlackText
                                )
                                val number = 100000
                                TextComponent(
                                    text = "(${
                                        if (other.size > 999) "999>" else other.size
                                    })",
                                    fontSize = if (other.size > 100) 14 else 16,
                                    color = BlackText
                                )

                            }
                        }
                    }
                }
                TextComponent(
                    text = "Atendimentos Recentes",
                    fontSize = 24,
                    color = BlackText
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(3) {
                        PersonCardComponent()
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


@Preview
@Composable
private fun ReportsScreenPreview() {
    ReportsScreen()

}

