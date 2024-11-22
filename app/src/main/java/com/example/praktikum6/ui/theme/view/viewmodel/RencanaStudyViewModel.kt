package com.example.praktikum6.ui.theme.view.viewmodel

import com.example.praktikum6.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RencanaStudyViewModel {
    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStudiUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()


}