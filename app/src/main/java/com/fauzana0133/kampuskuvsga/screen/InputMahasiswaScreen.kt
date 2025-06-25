package com.fauzana0133.kampuskuvsga.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fauzana0133.kampuskuvsga.model.MahasiswaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputMahasiswaScreen(
    navController: NavController,
    viewModel: MahasiswaViewModel = viewModel(),
    id: Int? = null
) {
    val existing = id?.let { viewModel.getMahasiswaById(it) }

    var nama by remember { mutableStateOf(existing?.nama ?: "") }
    var nim by remember { mutableStateOf(existing?.nim ?: "") }
    var jurusan by remember { mutableStateOf(existing?.jurusan ?: "") }
    var showError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (id != null) "Edit Mahasiswa" else "Input Mahasiswa",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = nim,
                onValueChange = { nim = it },
                label = { Text("NIM") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = jurusan,
                onValueChange = { jurusan = it },
                label = { Text("Jurusan") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (nama.isNotBlank() && nim.isNotBlank() && jurusan.isNotBlank()) {
                        if (id != null) {
                            viewModel.updateMahasiswa(id, nama, nim, jurusan)
                        } else {
                            viewModel.tambahMahasiswa(nama, nim, jurusan)
                        }
                        navController.popBackStack()
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("Simpan", color = Color.White)
            }

            if (showError) {
                Text(
                    text = "Semua field harus diisi!",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
