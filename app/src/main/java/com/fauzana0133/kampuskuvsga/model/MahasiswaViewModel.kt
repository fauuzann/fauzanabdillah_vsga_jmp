package com.fauzana0133.kampuskuvsga.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MahasiswaViewModel : ViewModel() {
    private var nextId = 1
    var listMahasiswa = mutableStateListOf<Mahasiswa>()
        private set

    fun tambahMahasiswa(nama: String, nim: String, jurusan: String) {
        listMahasiswa.add(
            Mahasiswa(
                id = nextId++,
                nama = nama,
                nim = nim,
                jurusan = jurusan
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun hapusMahasiswa(id: Int) {
        listMahasiswa.removeIf { it.id == id }
    }

    fun getMahasiswaById(id: Int): Mahasiswa? {
        return listMahasiswa.find { it.id == id }
    }

    fun updateMahasiswa(id: Int, nama: String, nim: String, jurusan: String) {
        val index = listMahasiswa.indexOfFirst { it.id == id }
        if (index != -1) {
            listMahasiswa[index] = Mahasiswa(id, nama, nim, jurusan)
        }
    }
}
