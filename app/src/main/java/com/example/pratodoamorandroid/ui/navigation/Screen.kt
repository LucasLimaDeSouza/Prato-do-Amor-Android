package com.example.pratodoamorandroid.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String,val arguments: List<NamedNavArgument> =emptyList()) {

    object LoginScreen: Screen(route = "login_screen")
    object PeoplesScreen: Screen(route = "people_screen")
    object ReportsScreen: Screen(route = "reports_screen")
    object ProfileScreen: Screen(route = "profile_screen")
    object PeopleCadasterScreen: Screen(route = "people_cadaster_screen")
    object RecoverPasswordScreen: Screen(route = "recover_password_screen")
    object ADMScreen: Screen(route = "admin_screen")
}