package com.fauzana0133.kampuskuvsga.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.fauzana0133.kampuskuvsga.navigation.Screen
import com.fauzana0133.kampuskuvsga.viewmodel.MahasiswaViewModel

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
            FloatingActionButton(onClick = {
                navController.navigate(Screen.InputMahasiswa.route)
            }) {
                Text("+")
            }
        }
    ) { inner ->
        Column(modifier = Modifier
            .padding(inner)
            .padding(16.dp)) {
            Text("Daftar Mahasiswa", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(viewModel.listMahasiswa) { mhs ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                selectedId = mhs.id
                                showDialog = true
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Nama: ${mhs.nama}")
                            Text(text = "NIM: ${mhs.nim}")
                        }
                    }
                }
            }

            // Dialog Aksi
            if (showDialog && selectedId != null) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Aksi") },
                    text = { Text("Pilih tindakan untuk data ini") },
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
