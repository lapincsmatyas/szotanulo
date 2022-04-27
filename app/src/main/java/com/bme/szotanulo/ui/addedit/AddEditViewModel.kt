package com.bme.szotanulo.ui.addedit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.SzotanuloService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val szotanuloService: SzotanuloService
) : ViewModel() {
}