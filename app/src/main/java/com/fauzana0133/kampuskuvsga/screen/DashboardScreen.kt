package com.fauzana0133.kampuskuvsga.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fauzana0133.kampuskuvsga.navigation.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Dashboard", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate(Screen.ListMahasiswa.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Lihat Data Mahasiswa")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(Screen.InputMahasiswa.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Input Data Mahasiswa")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(Screen.Info.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Informasi Aplikasi")
            }
        }
    }
}
