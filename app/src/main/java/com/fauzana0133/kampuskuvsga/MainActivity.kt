package com.fauzana0133.kampuskuvsga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.fauzana0133.kampuskuvsga.navigation.AppNavigation
import com.fauzana0133.kampuskuvsga.ui.theme.KampusKuVSGATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KampusKuVSGATheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}
