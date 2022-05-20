package com.bme.szotanulo.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cardApiService: CardApiService
) : ViewModel() {
    private val _response = MutableLiveData<List<Card>>()

    val response: LiveData<List<Card>>
        get() = _response

    init {
        getCardList()
    }

    private fun getCardList(){
        viewModelScope.launch {
            try {
                _response.value = cardApiService.getCards()
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
                _response.value = emptyList()
            }
        }
    }
}