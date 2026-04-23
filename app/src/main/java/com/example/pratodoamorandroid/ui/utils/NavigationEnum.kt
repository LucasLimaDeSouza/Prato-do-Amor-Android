package com.example.pratodoamorandroid.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pratodoamorandroid.ui.navigation.Screen

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    PEOPLES(route = Screen.PeoplesScreen.route, label = "Visits",icon = Icons.Default.Groups, contentDescription = "Atendidos"),
    REPORTS(route = "reports", label = "Reports", Icons.Default.AutoGraph, contentDescription = "Relatórios")
}