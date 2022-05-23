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
            if (!cards.isEmpty()) {
                cardDatabase.cardDao().deleteAllCards()
                cardDatabase.cardDao().insertCards(cards)
            }
        }
    }

    suspend fun createCard(card: Card){
        withContext(Dispatchers.IO) {
            val newCard = cardService.createCard(card)
            if (newCard != null) cardDatabase.cardDao().insertCard(card)
        }
    }

    suspend fun getCardById(cardId: Long): Card? {
        val result = cards.value?.firstOrNull { card -> card.id == cardId }
            ?: return cardService.getCardById(cardId)
        return result
    }

    suspend fun deleteCard(card: Card) {
        withContext(Dispatchers.IO) {
            cardService.deleteCard(card.id)
            cardDatabase.cardDao().deleteByCardId(card.id)
        }
    }
}