package com.bme.szotanulo.ui.practice

import androidx.lifecycle.ViewModel
import com.bme.szotanulo.network.CardService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PracticeViewModel @Inject constructor(
    private val szotanuloService: CardService
) : ViewModel()