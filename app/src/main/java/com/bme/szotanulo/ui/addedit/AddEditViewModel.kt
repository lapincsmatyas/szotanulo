package com.bme.szotanulo.ui.addedit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private val _backSideText = MutableLiveData<String?>()
    val backSideText: LiveData<String?>
        get() = _backSideText
    private val _frontSideText = MutableLiveData<String?>()
    val frontSideText: LiveData<String?>
        get() = _frontSideText

    var card: Card? = Card(
        frontSide = "",
        backSide = "",
        creationDate = Date(),
        lastReviewedDate = Date()
    )

    init {
        _frontSideText.value = card?.backSide
        _backSideText.value = card?.backSide
    }

    fun createCard() {
        viewModelScope.launch {
            try {
                card?.frontSide = frontSideText.value
                card?.backSide = backSideText.value
                cardApiService.createCard(card)
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }
    }

    fun initCard(cardId: Long) {
        if (cardId != -1L) {
            viewModelScope.launch {
                try {
                    card = cardApiService.getCardById(cardId)
                    _frontSideText.value = card?.frontSide
                    _backSideText.value = card?.backSide
                } catch (e: Exception) {
                    Log.e("Error", e.message.toString())
                }
            }
        }
    }
}