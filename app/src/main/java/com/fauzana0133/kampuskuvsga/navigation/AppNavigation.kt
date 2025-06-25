package com.fauzana0133.kampuskuvsga.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fauzana0133.kampuskuvsga.screen.*
import com.fauzana0133.kampuskuvsga.model.MahasiswaViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(
    navController: NavHostController,
    mahasiswaViewModel: MahasiswaViewModel
) {
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
            ListMahasiswaScreen(navController, mahasiswaViewModel)
        }
        composable(
            route = "${Screen.InputMahasiswa.route}?id={id}",
            arguments = listOf(navArgument("id") {
                nullable = true
                defaultValue = null
            })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            InputMahasiswaScreen(navController, mahasiswaViewModel, id) //
        }
        composable(Screen.Info.route) {
            InfoScreen(navController)
        }
    }
}

