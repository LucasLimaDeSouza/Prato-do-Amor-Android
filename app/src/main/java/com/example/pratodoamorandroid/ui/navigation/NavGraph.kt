package com.example.pratodoamorandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pratodoamorandroid.ui.screens.ADMScreen
import com.example.pratodoamorandroid.ui.screens.LoginScreen
import com.example.pratodoamorandroid.ui.screens.RecoverPasswordScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.ADMScreen.route,
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(Screen.RecoverPasswordScreen.route) {
            RecoverPasswordScreen(navController)
        }

        composable(Screen.ADMScreen.route) {
            ADMScreen(navController)
        }

    }

}