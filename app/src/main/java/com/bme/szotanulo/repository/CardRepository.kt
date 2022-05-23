package com.bme.szotanulo.repository

import androidx.lifecycle.LiveData
import com.bme.szotanulo.model.Card
import com.bme.szotanulo.network.CardApiService
import com.bme.szotanulo.persistence.CardDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardRepository @Inject constructor(
    private val cardDatabase: CardDatabase,
    private val cardService: CardApiService
) {
    val cards: LiveData<List<Card>> = cardDatabase.cardDao().getCards()

    suspend fun refreshCards() {
        withContext(Dispatchers.IO) {
            val cards = cardService.getCards()
            cardDatabase.cardDao().insertCards(cards)
        }
    }
}