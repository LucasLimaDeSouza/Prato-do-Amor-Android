package com.example.pratodoamorandroid.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String,val arguments: List<NamedNavArgument> =emptyList()) {

    object LoginScreen: Screen(route = "login_screen")
    object RecoverPasswordScreen: Screen(route = "recover_password_screen")
}