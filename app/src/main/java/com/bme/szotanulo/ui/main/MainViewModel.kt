package com.bme.szotanulo.ui.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bme.szotanulo.repository.CardRepository
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: CardRepository
) : ViewModel() {
    val cards = mainRepository.cards

    private val firebaseAnalytics = Firebase.analytics

    private val _navigateToCardEdit = MutableLiveData<Long>()
    val navigateToCardEdit
        get() = _navigateToCardEdit

    private var _networkError = MutableLiveData(false)
    val networkError: LiveData<Boolean>
        get() = _networkError

    init {
        refreshCards()
    }

    private fun refreshCards(){
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, null)
        viewModelScope.launch {
            try {
                mainRepository.refreshCards()
            } catch (networkError: IOException) {
                if(cards.value.isNullOrEmpty())
                    _networkError.value = true
            }
        }
    }

    fun onCardClicked(id: Long) {
        _navigateToCardEdit.value = id
    }
}