package com.bme.szotanulo.ui.addedit

import androidx.lifecycle.ViewModel
import com.bme.szotanulo.network.CardApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val cardApiService: CardApiService
) : ViewModel() {
}