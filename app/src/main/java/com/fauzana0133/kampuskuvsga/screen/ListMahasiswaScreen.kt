package com.fauzana0133.kampuskuvsga.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fauzana0133.kampuskuvsga.navigation.Screen
import com.fauzana0133.kampuskuvsga.model.MahasiswaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ListMahasiswaScreen(
    navController: NavController,
    viewModel: MahasiswaViewModel = viewModel()
) {
    var selectedId by remember { mutableStateOf<Int?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.InputMahasiswa.route) },
                containerColor = Color(0xFF4CAF50),
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Tambah")
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("Data Mahasiswa", color = MaterialTheme.colorScheme.onPrimary) },
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
                .padding(16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.listMahasiswa) { mhs ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedId = mhs.id
                                showDialog = true
                            },
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E6C9)) // hijau pastel
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Nama: ${mhs.nama}", style = MaterialTheme.typography.bodyLarge)
                            Text(text = "NIM: ${mhs.nim}")
                            Text(text = "Jurusan: ${mhs.jurusan}")
                        }
                    }
                }
            }

            if (showDialog && selectedId != null) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Aksi Data") },
                    text = { Text("Pilih aksi untuk data ini") },
                    confirmButton = {
                        TextButton(onClick = {
                            navController.navigate("${Screen.InputMahasiswa.route}?id=$selectedId")
                            showDialog = false
                        }) {
                            Text("Update")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            viewModel.hapusMahasiswa(selectedId!!)
                            showDialog = false
                        }) {
                            Text("Hapus")
                        }
                    }
                )
            }
        }
    }
}
