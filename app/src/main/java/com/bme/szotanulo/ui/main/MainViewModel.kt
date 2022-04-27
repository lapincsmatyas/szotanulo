package com.bme.szotanulo.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.SzotanuloService
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val szotanuloService: SzotanuloService
) : ViewModel() {
    var cardList: List<Card> = szotanuloService.getCards()

}