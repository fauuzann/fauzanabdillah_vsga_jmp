package com.fauzana0133.kampuskuvsga.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fauzana0133.kampuskuvsga.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tentang Aplikasi", color = MaterialTheme.colorScheme.onPrimary) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali", tint = MaterialTheme.colorScheme.onPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }

    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .background(Color(0xFFE8F5E9))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Foto profil bulat
            Image(
                painter = painterResource(id = R.drawable.profil_fauzan),
                contentDescription = "Foto Fauzan",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Text(
                text = "Aplikasi KampusKu",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF388E3C)
            )

            Text("Versi: 1.0.0", fontSize = 14.sp)

            Text(
                text = "Aplikasi ini dibuat untuk membantu mendata informasi mahasiswa, dengan fitur tambah, lihat, ubah, dan hapus data.",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Developer: Fauzan Abdillah", fontSize = 14.sp)
        }
    }
}
