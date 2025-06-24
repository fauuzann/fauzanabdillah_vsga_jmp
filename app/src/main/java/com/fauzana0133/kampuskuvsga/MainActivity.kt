package com.fauzana0133.kampuskuvsga

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import com.fauzana0133.kampuskuvsga.navigation.AppNavigation
import com.fauzana0133.kampuskuvsga.ui.theme.KampusKuVSGATheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fauzana0133.kampuskuvsga.viewmodel.MahasiswaViewModel


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KampusKuVSGATheme {
                val navController = rememberNavController()
                val mahasiswaViewModel: MahasiswaViewModel = viewModel()
                AppNavigation(navController, mahasiswaViewModel)
            }
        }

    }
}
