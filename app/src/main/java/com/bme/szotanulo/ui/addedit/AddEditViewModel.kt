package com.bme.szotanulo.ui.addedit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardApiService
import com.bme.szotanulo.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val cardRepository: CardRepository
) : ViewModel() {
    var _frontText = MutableLiveData<String>("")
    var _backText = MutableLiveData<String>("")

    var card: Card? = Card(
        frontSide = "",
        backSide = "",
        creationDate = Date(),
        lastReviewedDate = Date()
    )

    fun createCard() {
        viewModelScope.launch {
            try {
                card?.frontSide = _frontText.value
                card?.backSide = _backText.value
                cardRepository.createCard(card!!)
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
    }

    fun initCard(cardId: Long) {
        if (cardId != -1L) {
            viewModelScope.launch {
                try {
                    card = cardRepository.getCardById(cardId)
                    _frontText.value = card?.frontSide!!
                    _frontText.value = card?.backSide!!

                } catch (e: Exception) {
                    Log.e("Error", e.message.toString())
                }
            }
        }
    }

    fun deleteCard() {
        viewModelScope.launch {
            try {
                cardRepository.deleteCard(card!!)
                _frontText.value = card?.frontSide!!
                _frontText.value = card?.backSide!!

            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
    }
}