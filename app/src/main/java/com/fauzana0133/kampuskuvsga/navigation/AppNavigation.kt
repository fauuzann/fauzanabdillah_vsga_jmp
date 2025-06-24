package com.fauzana0133.kampuskuvsga.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fauzana0133.kampuskuvsga.screen.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController)
        }

        composable(Screen.ListMahasiswa.route) {
            Text("List Mahasiswa - Coming Soon")
        }
        composable(Screen.InputMahasiswa.route) {
            Text("Input Mahasiswa - Coming Soon")
        }
        composable(Screen.Info.route) {
            Text("Informasi Aplikasi - Coming Soon")
        }

    }
}
