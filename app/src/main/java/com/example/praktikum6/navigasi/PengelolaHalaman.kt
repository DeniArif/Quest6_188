package com.example.praktikum6.navigasi

import MahasiswaFormView
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6.model.Mahasiswa
import com.example.praktikum6.ui.theme.view.screen.RencanaStudyView
import com.example.praktikum6.ui.theme.view.screen.SplashScreen
import com.example.praktikum6.ui.theme.view.screen.TampilData
import com.example.praktikum6.ui.theme.view.viewmodel.MahasiswaViewModel
import com.example.praktikum6.ui.theme.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahassiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsState = krsViewModel.krsStudiUi.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashScreen(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSimpanButtonClicked = {
                    mahasiswaViewModel.saveData(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahassiswaUiState,
                onSubmitButtonClicked = { krsViewModel.saveDataKRS(it)
                                        navController.navigate(Halaman.Tampil.name)},
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        composable(route = Halaman.Tampil.name){
             TampilData(
                 mahasiswa = mahassiswaUiState,
                 rencanaStudi = krsState,
                 onBackButtonClicked = {
                     navController.navigate(Halaman.Splash.name){
                         popUpTo(0) { inclusive = true }
                     }

                 }
             )
        }
    }

}
