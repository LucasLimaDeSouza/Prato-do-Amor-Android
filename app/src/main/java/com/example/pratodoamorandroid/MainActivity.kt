package com.example.pratodoamorandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.pratodoamorandroid.ui.navigation.NavGraph
import com.example.pratodoamorandroid.ui.theme.PratoDoAmorAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PratoDoAmorAndroidTheme {
                val navController = rememberNavController()
                NavGraph(navController)

            }
        }
    }
}

