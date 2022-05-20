package com.bme.szotanulo.ui.addedit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val cardApiService: CardApiService
) : ViewModel() {

    fun createCard() {
        val newCard = Card(
            frontSide = "new",
            backSide = "új",
            creationDate = Date(),
            lastReviewedDate = Date()
        )

        viewModelScope.launch {
            try {
                cardApiService.createCard(newCard)
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
    }
}