package com.bme.szotanulo.ui.main

import androidx.lifecycle.ViewModel
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    var cardList: Flow<List<Card>> = mainRepository.getCards()
}