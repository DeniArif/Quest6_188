package com.example.praktikum6.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.praktikum6.model.Mahasiswa
import com.example.praktikum6.ui.theme.view.viewmodel.MahasiswaViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController
)
