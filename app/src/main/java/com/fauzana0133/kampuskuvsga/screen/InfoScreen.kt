package com.fauzana0133.kampuskuvsga.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Tentang Aplikasi") })
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("📱 Aplikasi KampusKu", style = MaterialTheme.typography.headlineSmall)
            Text("Versi: 1.0.0")
            Text("Aplikasi ini digunakan untuk mendata informasi mahasiswa, termasuk fitur tambah, lihat, ubah, dan hapus data.")
            Spacer(modifier = Modifier.height(12.dp))
            Text("👤 Developer: Fauzan Abdillah")
        }
    }
}
