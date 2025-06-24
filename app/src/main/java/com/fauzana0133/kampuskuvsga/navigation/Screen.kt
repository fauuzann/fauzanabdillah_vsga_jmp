package com.fauzana0133.kampuskuvsga.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object ListMahasiswa : Screen("list_mahasiswa")
    object InputMahasiswa : Screen("input_mahasiswa")
    object Info : Screen("info")

}
